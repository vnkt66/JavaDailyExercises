package com.main.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.model.Hanger;
import com.main.model.Plane;
import com.main.service.PlaneService;

/**
 * @author venkanna chowdary penubothu This Controller contains methods that
 *         handles all plane requests
 */
@Controller
public class PlaneController {
	private static final Logger log = Logger.getLogger(PlaneController.class);

	@Autowired
	private PlaneService planeService;

	@RequestMapping(value = "/addPlane", params = { "newPlane" })
	public String loadNewPlaneForm(ModelMap map) {
		log.info("Inside Plane loadNew Form");
		Plane plane = new Plane();
		map.addAttribute("addPlaneForm", plane);
		return "AddPlane";
	}

	@RequestMapping(value = "/savePlane", method = RequestMethod.POST)
	public String saveStudent(@Validated @ModelAttribute("addPlaneForm") Plane plane, BindingResult br, ModelMap map) {
		String viewPage;
		if (br.hasErrors()) {
			log.info("Saving Plane Failed");
			viewPage = "AddPlane";
		} else {
			Random random = new Random();
			Long planeId = (long) random.nextInt(400000);
			plane.setPlaneId(planeId);
			plane.setStatus("available");
			planeService.savePlane(plane);
			log.info("Saving Plane Succesful");
			viewPage = "Success";
		}
		return viewPage;
	}

	@RequestMapping(value = "/fetchPlanes")
	public String fetchAllPlanes(ModelMap map) {
		List<Plane> planeList = planeService.fetchAllPlanes();
		log.info("Fetching done");
		log.info(planeList);
		map.addAttribute("planeList", planeList);
		return "ViewPlanes";
	}

	@RequestMapping(value = "/fetchPlaneById/{planeId}")
	public String fetchPlane(@PathVariable("planeId") Integer id, RedirectAttributes redirectAttributes, ModelMap map) {
		Plane plane = planeService.fetchPlaneById(id);
		log.info("Fetching Single Plane completed");
		map.addAttribute("plane", plane);
		redirectAttributes.addFlashAttribute("plane", plane);
		return "redirect:/fetchPlane";
	}

	@RequestMapping(value = "/fetchPlane")
	public String fetchPlaneRedirect(@ModelAttribute("plane") Plane plane, ModelMap map) {
		map.addAttribute("plane", plane);
		return "ViewPlane";
	}

	@RequestMapping(value = "/fetchById/{planeId}", params = { "plane" })
	public String fetchPlaneById(@PathVariable("planeId") Integer id, ModelMap map) {
		Plane plane = planeService.fetchPlaneById(id);
		log.info("Fetching done");
		map.addAttribute("updatePlaneForm", plane);
		return "UpdatePlane";
	}

	@RequestMapping(value = "/editPlane", method = RequestMethod.POST)
	public String updatePlane(@Validated @ModelAttribute("updatePlaneForm") Plane plane, BindingResult br,
			ModelMap map) {
		String viewPage;
		if (br.hasErrors()) {
			viewPage = "UpdatePlane";
		} else {
			planeService.updatePlane(plane);
			List<Plane> planeList = planeService.fetchAllPlanes();
			map.addAttribute("planeList", planeList);
			viewPage = "Success";
		}
		return viewPage;
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

}