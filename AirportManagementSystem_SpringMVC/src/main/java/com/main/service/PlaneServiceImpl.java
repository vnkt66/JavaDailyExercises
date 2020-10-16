package com.main.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.dao.PlaneDao;
import com.main.model.Pilot;
import com.main.model.Hanger;
import com.main.model.Plane;

/**
 * @author venkanna chowdary penubothu This PlaneServiceImpl contains methods
 *         that handles all plane, pilot user, hanger requests from controller
 *         and calls dao layer methods
 */
@Service
@Transactional
public class PlaneServiceImpl implements PlaneService {
	private static final Logger log = Logger.getLogger(PlaneServiceImpl.class);

	@Autowired
	private PlaneDao planeDao;

	@Override
	public void savePlane(Plane plane) {
		// TODO Auto-generated method stub
		log.info("SavePlane Service");
		planeDao.savePlane(plane);
	}

	@Override
	public List<Plane> fetchAllPlanes() {
		// TODO Auto-generated method stub
		List<Plane> planeList = planeDao.fetchAllPlanes();
		return planeList;
	}

	@Override
	public List<Plane> fetchAllPlanesByStatus(String status) {
		// TODO Auto-generated method stub
		List<Plane> planeList = planeDao.fetchAllPlanesByStatus(status);
		return planeList;
	}

	@Override
	public Plane fetchPlaneById(long id) {
		// TODO Auto-generated method stub
		Plane plane = planeDao.fetchPlaneById(id);
		return plane;
	}

	@Override
	public void updatePlane(Plane plane) {
		// TODO Auto-generated method stub
		planeDao.updatePlane(plane);
	}

	@Override
	public void savePilot(Pilot pilot) {
		// TODO Auto-generated method stub
		log.info("SavePilot Service");
		planeDao.savePilot(pilot);
	}

	@Override
	public List<Pilot> fetchAllPilots() {
		// TODO Auto-generated method stub
		List<Pilot> pilotList = planeDao.fetchAllPilots();
		return pilotList;
	}

	@Override
	public Pilot fetchPilotById(long id) {
		// TODO Auto-generated method stub
		Pilot pilot = planeDao.fetchPilotById(id);
		return pilot;
	}

	@Override
	public void updatePilot(Pilot pilot) {
		// TODO Auto-generated method stub
		planeDao.updatePilot(pilot);
	}

	@Override
	public void saveHanger(Hanger hanger) {
		// TODO Auto-generated method stub
		log.info("SaveHanger Service");
		planeDao.saveHanger(hanger);
	}

	@Override
	public List<Hanger> fetchAllHangers() {
		// TODO Auto-generated method stub
		List<Hanger> hangerList = planeDao.fetchAllHangers();
		return hangerList;
	}

	@Override
	public List<Hanger> fetchAllHangersByStatus(String status) {
		// TODO Auto-generated method stub
		List<Hanger> hangerList = planeDao.fetchAllHangersByStatus(status);
		return hangerList;
	}

	@Override
	public Hanger fetchHangerById(long id) {
		// TODO Auto-generated method stub
		Hanger hanger = planeDao.fetchHangerById(id);
		return hanger;
	}

	@Override
	public void updateHanger(Hanger hanger) {
		// TODO Auto-generated method stub
		planeDao.updateHanger(hanger);
	}

}
