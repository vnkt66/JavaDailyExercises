package com.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.main.model.Gender;
import com.main.model.Manager;
import com.main.service.ManagerService;

/**
 * @author venkanna chowdary penubothu This Controller contains methods that
 *         handles all manager user requests
 */
@Controller
public class ManagerController {
	private static final Logger log = Logger.getLogger(ManagerController.class);

	@Autowired
	private ManagerService managerService;

	@RequestMapping(value = "/managerregister")
	public String loadManagerRegisterForm(HttpSession session, ModelMap map) {
		log.info("Inside Manager loadRegister Form");
		if (isAuthenticated(session, map)) {
			Manager oldManager = managerService.fetchManagerById((long) session.getAttribute("managerId"));
			String oldManagerName = oldManager.getFirstName() + " " + oldManager.getLastName();
			map.addAttribute("managerName", oldManagerName);
			return "ManagerHomePage";
		}
		Manager manager = new Manager();
		genderInit(map);
		map.addAttribute("managerRegisterForm", manager);
		return "ManagerRegister";
	}

	@RequestMapping(value = "/managerlogin")
	public String loadManagerLoginForm(HttpSession session, ModelMap map) {
		log.info("Inside Manager loadLogin Form");
		if (isAuthenticated(session, map)) {
			Manager oldManager = managerService.fetchManagerById((long) session.getAttribute("managerId"));
			map.addAttribute("managerName", oldManager.getFirstName() + oldManager.getLastName());
			return "ManagerHomePage";
		}
		Manager manager = new Manager();
		map.addAttribute("managerLoginForm", manager);
		return "ManagerLogin";
	}

	@RequestMapping(value = "/saveManager", method = RequestMethod.POST)
	public String saveManager(@Validated @ModelAttribute("managerRegisterForm") Manager manager, BindingResult br,
			ModelMap map, HttpSession session) {
		String viewPage;
		if (br.hasErrors()) {
			log.info("Saving Failed");
			genderInit(map);
			viewPage = "ManagerRegister";
		} else {
			Random random = new Random();
			Long managerId = (long) random.nextInt(400000);
			manager.setManagerId(managerId);
			managerService.saveManager(manager);
			log.info("Saving Succesful");
			log.info(manager.getManagerId());
			session.setAttribute("managerId", manager.getManagerId());
			viewPage = "redirect:managerlogin";
		}
		return viewPage;
	}

	@RequestMapping(value = "/fetchManager")
	public String fetchEmployeeById(@RequestParam("managerId") long id, @RequestParam("password") String password,
			HttpSession session, ModelMap map) {
//		@RequestParam("managerId") long id
//		session.removeAttribute("managerId");
		session.removeAttribute("adminId");
//	    Long managerId = (Long) session.getAttribute("managerId");
		Manager manager = managerService.fetchManagerById(id);
		if (manager != null && password.equals(manager.getPassword())) {
			if (session.getAttribute("managerId") == null) {
				session.setAttribute("managerId", manager.getManagerId());
			}
			log.info("Fetching done");
			log.info(manager.getManagerId());
			map.addAttribute("managerId", manager.getManagerId());
			map.addAttribute("managerName", manager.getFirstName() + manager.getLastName());
			return "ManagerHomePage";
		} else {
			return "redirect:managerlogin";
		}
	}

	@RequestMapping(value = "/managerLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:managerlogin";
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
		log.info(session.getAttribute("managerId"));
		Object object = session.getAttribute("managerId");
		if (object != null) {
			map.addAttribute("managerId", (long) object);
			log.info("Inside isAuthenticated if");
			return true;
		} else {
			log.info("Inside isAuthenticated else ");
			return false;
		}

	}

	void genderInit(ModelMap map) {
		List<Gender> genderList = new ArrayList<Gender>();
		genderList.add(Gender.MALE);
		genderList.add(Gender.FEMALE);
		genderList.add(Gender.OTHER);
		map.addAttribute("genderList", genderList);
	}

}
