package com.main.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.model.Admin;
import com.main.model.Plane;
import com.main.service.AdminService;
import com.main.service.PlaneService;

/**
 * @author venkanna chowdary penubothu This Controller contains methods that
 *         handles all admin user requests
 */
@Controller
public class AdminController {
	private static final Logger log = Logger.getLogger(AdminController.class);

	@Autowired
	private AdminService adminService;
	@Autowired
	private PlaneService planeService;

	@RequestMapping(value = "/adminregister")
	public String loadAdminRegisterForm(ModelMap map) {
		log.info("Inside Admin loadRegister Form");
		Admin admin = new Admin();
		map.addAttribute("adminRegisterForm", admin);
		return "AdminRegister";
	}

	@RequestMapping(value = "/adminlogin")
	public String loadAdminLoginForm(HttpSession session, ModelMap map) {
		log.info("Inside Admin loadLogin Form");
		if (isAuthenticated(session, map)) {
			return "redirect:adminApprovals";
		}
		Admin admin = new Admin();
		map.addAttribute("adminLoginForm", admin);
		return "AdminLogin";
	}

	@RequestMapping(value = "/saveAdmin", method = RequestMethod.POST)
	public String saveAdmin(@ModelAttribute("adminRegisterForm") Admin admin, ModelMap map) {
		adminService.saveAdmin(admin);
		log.info("Saving Succesful");
		return "Success";
	}

	@RequestMapping(value = "/fetchAdmin")
	public String fetchAdminById(@RequestParam("id") Long id, @RequestParam("password") String password, ModelMap map,
			RedirectAttributes redirectAttributes, HttpSession session) {
		Admin admin = adminService.fetchAdminById(id);
		log.info("Fetching done");
		log.info(admin);
		log.info(password.equals(admin.getPassword()));
		if (admin != null && password.equals(admin.getPassword())) {
			if (session.getAttribute("adminId") == null) {
				session.removeAttribute("managerId");
				session.setAttribute("adminId", id);
			}
			redirectAttributes.addFlashAttribute("adminId", admin.getId());
//		map.addAttribute("adminId", admin.getId());
			return "redirect:adminApprovals";
		} else {
			return "redirect:adminlogin";
		}
	}

	@RequestMapping(value = "/adminApprovals")
	public String fetchAdminApprovals(HttpSession session, ModelMap map) {
//		@ModelAttribute("adminId") Long id
		Long adminId = (Long) session.getAttribute("adminId");
		Admin admin = adminService.fetchAdminById(adminId);
		List<Plane> planeList = planeService.fetchAllPlanesByStatus("assigned");
		map.addAttribute("adminId", adminId);
		map.addAttribute("adminName", admin.getName());
		map.addAttribute("planeList", planeList);
		return "AdminApprovals";
	}

	@RequestMapping(value = "/approveRequestById/{planeId}")
	public String approveRequestById(@PathVariable("planeId") Long id, ModelMap map) {
		Plane plane = planeService.fetchPlaneById(id);
		plane.setStatus("allocated");
		plane.getHanger().setStatus("allocated");
		planeService.updatePlane(plane);
		log.info("Inside approveRequestById Plane Hanger status saved");
		log.info(planeService.fetchPlaneById(id));
		return "redirect:/adminApprovals";
	}

	@RequestMapping(value = "/adminLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:adminlogin";
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		log.error("Request: " + req.getRequestURL() + " raised " + ex);

		ModelAndView modelView = new ModelAndView();
		modelView.addObject("exception", ex);
		modelView.addObject("url", req.getRequestURL());
		modelView.setViewName("Error");
		return modelView;
	}

	public boolean isAuthenticated(HttpSession session, ModelMap map) {
		log.info("I am inside isAuthenticated");
		log.info(session.getAttribute("adminId"));
		Object object = session.getAttribute("adminId");
		if (object != null) {
			log.info("Inside Admin isAuthenticated if");
			return true;
		} else {
			log.info("Inside Admin isAuthenticated else ");
			return false;
		}

	}

}
