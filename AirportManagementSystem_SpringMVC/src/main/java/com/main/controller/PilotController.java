package com.main.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.model.Gender;
import com.main.model.Hanger;
import com.main.model.Pilot;
import com.main.model.Plane;
import com.main.service.PlaneService;

/**
 * @author venkanna chowdary penubothu This Controller contains methods that
 *         handles all pilot user requests
 */
@Controller
public class PilotController {
	private static final Logger log = Logger.getLogger(PilotController.class);

	@Autowired
	private PlaneService planeService;

	@RequestMapping(value = "/addPlane", params = { "newPilot" })
	public String loadNewPilotForm(ModelMap map) {
		log.info("Inside Pilot loadNew Form");
		Pilot pilot = new Pilot();
		genderInit(map);
		pilotIdInit(map);
		map.addAttribute("addPilotForm", pilot);
		return "AddPilot";
	}

	@RequestMapping(value = "/savePilot", method = RequestMethod.POST)
	public String saveStudent(@Validated @ModelAttribute("addPilotForm") Pilot pilot, BindingResult br, ModelMap map) {
		String viewPage;
		Random random = new Random();
		Long pilotId = (long) random.nextInt(400000);
		pilot.setPilotId(pilotId);
		if (br.hasErrors()) {
			log.info("Saving Pilot Failed");
			genderInit(map);
			pilotIdInit(map);
			viewPage = "AddPilot";
		} else {
			if (pilot.getPlaneIdRef() != 0) {
				Plane plane = planeService.fetchPlaneById(pilot.getPlaneIdRef());
				pilot.setPlane(plane);
				plane.setPilot(pilot);
				log.info(plane.getPilot());
				planeService.savePilot(pilot); // eye
				planeService.updatePlane(plane);
			} else {
				log.info("No plane Id Inside Pilot Add");
				planeService.savePilot(pilot);
			}
			log.info("Saving Pilot Succesful");
			viewPage = "Success";
		}
		return viewPage;
	}

	@RequestMapping(value = "/fetchPilots")
	public String fetchAllPilots(ModelMap map) {
		List<Pilot> pilotList = planeService.fetchAllPilots();
		log.info("Fetching Pilots done");
		log.info(pilotList);
		map.addAttribute("pilotList", pilotList);
		return "ViewPilots";
	}

	@RequestMapping(value = "/fetchPilotById/{pilotId}")
	public String fetchPlane(@PathVariable("pilotId") Long id, RedirectAttributes redirectAttributes, ModelMap map) {
		Pilot pilot = planeService.fetchPilotById(id);
		log.info("Fetching Single Pilot completed");
		map.addAttribute("pilot", pilot);
		redirectAttributes.addFlashAttribute("pilot", pilot);
		return "redirect:/fetchPilot";
	}

	@RequestMapping(value = "/fetchPilot")
	public String fetchPilotRedirect(@ModelAttribute("pilot") Pilot pilot, ModelMap map) {
		map.addAttribute("pilot", pilot);
		return "ViewPilot";
	}

	@RequestMapping(value = "/fetchById/{pilotId}", params = { "pilot" })
	public String fetchPilotById(@PathVariable("pilotId") Long id, ModelMap map) {
		Pilot pilot = planeService.fetchPilotById(id);
		log.info("Fetching Pilot done");
		genderInit(map);
		pilotIdInit(map);
		map.addAttribute("updatePilotForm", pilot);
		return "UpdatePilot";
	}

	@RequestMapping(value = "/editPilot", method = RequestMethod.POST)
	public String updatePlane(@Validated @ModelAttribute("updatePilotForm") Pilot pilot, BindingResult br,
			ModelMap map) {
		String viewPage;
		if (br.hasErrors()) {
			genderInit(map);
			pilotIdInit(map);
			viewPage = "UpdatePilot";
		} else {
			if (pilot.getPlaneIdRef() != 0) {
				Pilot pilotOne = planeService.fetchPilotById(pilot.getPilotId());
				Plane plane = planeService.fetchPlaneById(pilotOne.getPlaneIdRef());
				if (plane != null) {
					plane.setPilot(null);
					planeService.updatePlane(plane);
				}
				Plane newPlane = planeService.fetchPlaneById(pilot.getPlaneIdRef());
				newPlane.setPilot(pilot);
				planeService.updatePilot(pilot); // eye
				planeService.updatePlane(newPlane);

			}
//			Plane plane = planeService.fetchPlaneById(pilot.getPlaneIdRef());
//			pilot.setPlane(plane);
//			plane.setPilot(pilot);
//			planeService.updatePilot(pilot);
//			planeService.updatePlane(plane);
			else {
				Pilot oldPilot = planeService.fetchPilotById(pilot.getPilotId());
				if (oldPilot.getPlaneIdRef() != 0) {
					log.info("Inside oldPilot to update Plane PilotId");
					Plane plane = planeService.fetchPlaneById(oldPilot.getPlaneIdRef());
					plane.setPilot(null);
					planeService.updatePilot(pilot);
					planeService.updatePlane(plane);
				} else {
					planeService.updatePilot(pilot);
				}
			}
			List<Pilot> pilotList = planeService.fetchAllPilots();
			map.addAttribute("pilotList", pilotList);
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

	void genderInit(ModelMap map) {
		List<Gender> genderList = new ArrayList<Gender>();
		genderList.add(Gender.MALE);
		genderList.add(Gender.FEMALE);
		genderList.add(Gender.OTHER);
		map.addAttribute("genderList", genderList);
	}

	void pilotIdInit(ModelMap map) {
		final List<Long> planeIdList = new ArrayList<Long>();
		List<Plane> planes = planeService.fetchAllPlanes();
		planes.forEach(new Consumer<Plane>() {
			@Override
			public void accept(Plane plane) {
				planeIdList.add(plane.getPlaneId());
			}
		});
		map.addAttribute("planeIdList", planeIdList);
	}

}