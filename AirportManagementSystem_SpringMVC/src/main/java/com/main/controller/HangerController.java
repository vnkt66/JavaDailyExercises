package com.main.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
//import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
//import java.util.stream.Stream;

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
 *         handles all hanger requests
 */
@Controller
public class HangerController {
	private static final Logger log = Logger.getLogger(HangerController.class);

	@Autowired
	private PlaneService planeService;

	@RequestMapping(value = "/addPlane", params = { "newHanger" })
	public String loadNewHangerForm(ModelMap map) {
		log.info("Inside Hanger loadNew Form");
		Hanger hanger = new Hanger();
		pilotIdInit(map);
		map.addAttribute("addHangerForm", hanger);
		return "AddHanger";
	}

	@RequestMapping(value = "/saveHanger", method = RequestMethod.POST)
	public String saveHanger(@Validated @ModelAttribute("addHangerForm") Hanger hanger, BindingResult br,
			ModelMap map) {
		String viewPage;
		Random random = new Random();
		Long hangerId = (long) random.nextInt(400000);
		hanger.setHangerId(hangerId);
		if (br.hasErrors()) {
			log.info("Saving Hanger Failed");
			log.info(hanger.getPlaneIdRef());
			pilotIdInit(map);
			viewPage = "AddHanger";
		} else {
			if (hanger.getPlaneIdRef() != 0) {
				Plane plane = planeService.fetchPlaneById(hanger.getPlaneIdRef());
				log.info("save Hanger planeIdRef");
				log.info(hanger.getPlaneIdRef());
//			hanger.setPlane(plane);
				plane.setHanger(hanger);
				plane.setStatus("assigned");
				hanger.setStatus("assigned");
				log.info(plane.getHanger());
				log.info("Got plane Id Inside Hanger Add");
				planeService.saveHanger(hanger);// try
				planeService.updatePlane(plane);
			} else {
				log.info("No plane Id Inside Hanger Add");
				hanger.setStatus("available");
				planeService.saveHanger(hanger);
			}
			log.info("Saving Hanger Succesful");
			viewPage = "Success";
		}
		return viewPage;
	}

	@RequestMapping(value = "/fetchHangers")
	public String fetchAllHangers(ModelMap map) {
		List<Hanger> hangerList = planeService.fetchAllHangers();
		log.info("Fetching Hangers done");
		log.info(hangerList);
		map.addAttribute("hangerList", hangerList);
		return "ViewHangers";
	}

	@RequestMapping(value = "/fetchHangerById/{hangerId}")
	public String fetchHanger(@PathVariable("hangerId") Long id, RedirectAttributes redirectAttributes, ModelMap map) {
		Hanger hanger = planeService.fetchHangerById(id);
		log.info("Fetching Single Hanger completed");
		map.addAttribute("hanger", hanger);
		redirectAttributes.addFlashAttribute("hanger", hanger);
		return "redirect:/fetchHanger";
	}

	@RequestMapping(value = "/fetchHanger")
	public String fetchHangerRedirect(@ModelAttribute("hanger") Hanger hanger, ModelMap map) {
		map.addAttribute("hanger", hanger);
		return "ViewHanger";
	}

	@RequestMapping(value = "/fetchById/{hangerId}", params = { "hanger" })
	public String fetchHangerById(@PathVariable("hangerId") Long id, ModelMap map) {
		Hanger hanger = planeService.fetchHangerById(id);
		log.info("Fetching Hanger done");
		pilotIdInit(map);
		map.addAttribute("updateHangerForm", hanger);
		return "UpdateHanger";
	}

	@RequestMapping(value = "/editHanger", method = RequestMethod.POST)
	public String updateHanger(@Validated @ModelAttribute("updateHangerForm") Hanger hanger, BindingResult br,
			ModelMap map) {
		String viewPage;
		if (br.hasErrors()) {
			pilotIdInit(map);
			viewPage = "UpdateHanger";
		} else {
			if (hanger.getPlaneIdRef() != 0) {
				Hanger hangerOne = planeService.fetchHangerById(hanger.getHangerId());
				Plane plane = planeService.fetchPlaneById(hangerOne.getPlaneIdRef());
				if (plane != null) {
					plane.setStatus("available");
					plane.setHanger(null);
					planeService.updatePlane(plane);
				}
//				hanger.setPlane(plane);
//				if(plane.getStatus() != "allocated") {
//					plane.setStatus("assigned");
//					hanger.setStatus("assigned");
//				}
				Plane newPlane = planeService.fetchPlaneById(hanger.getPlaneIdRef());
				newPlane.setHanger(hanger);
				newPlane.setStatus("assigned");
				hanger.setStatus("assigned");
				planeService.updateHanger(hanger); // eye
				planeService.updatePlane(newPlane);
			} else {
				Hanger oldHanger = planeService.fetchHangerById(hanger.getHangerId());
				if (oldHanger.getPlaneIdRef() != 0) {
					log.info("Inside oldHanger to update Plane HangerId and Status");
					Plane plane = planeService.fetchPlaneById(oldHanger.getPlaneIdRef());
					plane.setStatus("available");
					plane.setHanger(null);
					hanger.setStatus("available");
					planeService.updateHanger(hanger);
					planeService.updatePlane(plane);
				} else {
					hanger.setStatus("available");
					planeService.updateHanger(hanger);
				}
			}
			List<Hanger> hangerList = planeService.fetchAllHangers();
			map.addAttribute("hangerList", hangerList);
			viewPage = "Success";
		}
		return viewPage;
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

	@RequestMapping(value = "/allotHanger")
	public String allotHanger(ModelMap map) {
		log.info("Inside Allot Hanger");
//		List<Hanger> hangerList = planeService.fetchAllHangers();
		List<Plane> planeList = planeService.fetchAllPlanesByStatus("available");
		List<Hanger> hangerList = planeService.fetchAllHangersByStatus("available");
//		List<Object> hangerList = getAvailableStatusHangers();
//		Stream<Plane> planes = planeList.stream().filter(new Predicate<Plane>() {
//			@Override
//			public boolean test(Plane plane) {
//				return plane.getStatus() != "available";
//			}
//		});
//		List<Object> hangers = planes.map(new Function<Plane, Object>() {
//			@Override
//			public Object apply(Plane plane) {
//				return plane.getHanger();
//			}
//		}).collect(Collectors.toList());
		map.addAttribute("planeList", planeList);
		map.addAttribute("hangerList", hangerList);
		return "HangerAllocationPage";
	}

	@RequestMapping(value = "/viewHangers")
	public String viewAllHangers(ModelMap map) {
//		List<Hanger> assignedHangers = getHangersByStatus("assigned");
//		List<Hanger> allocatedHangers = getHangersByStatus("allocated");
//		List<Object> availableHangers = getAvailableStatusHangers();
		List<Hanger> availableHangers = planeService.fetchAllHangersByStatus("available");
		List<Hanger> assignedHangers = planeService.fetchAllHangersByStatus("assigned");
		List<Hanger> allocatedHangers = planeService.fetchAllHangersByStatus("allocated");
		log.info("Available Hangers List");
		log.info(availableHangers);
		map.addAttribute("availableHangers", availableHangers);
		map.addAttribute("assignedHangers", assignedHangers);
		map.addAttribute("allocatedHangers", allocatedHangers);
		return "HangerStatusView";
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

//	public List<Hanger> getHangersByStatus(String status) {
//		Iterator<Plane> iterator = planeService.fetchAllPlanesByStatus(status).iterator();
//		List<Hanger> HangerList = new ArrayList<Hanger>();
//		while(iterator.hasNext()) {
//			HangerList.add(iterator.next().getHanger());
//		}
//		return HangerList;
//	}

//	public List<Object> getAvailableStatusHangers() {
//		final List<Plane> planeList = planeService.fetchAllPlanes();
//		final List<Hanger> hangerList = new ArrayList<Hanger>();
//		List<Object> availableHangerList = hangerList.stream()
//        .filter(new Predicate<Hanger>() {
//			@Override
//			public boolean test(final Hanger hanger) {
//				return planeList.stream().anyMatch(new Predicate<Plane>() {
//					@Override
//					public boolean test(Plane plane) {
//						return hanger != plane.getHanger();
//					}
//				});
//			}
//		})
//        .collect(Collectors.toList());
//		return availableHangerList;
//	}

}