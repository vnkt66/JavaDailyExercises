package com.main.service;

import java.util.List;

import com.main.model.Hanger;
import com.main.model.Pilot;
import com.main.model.Plane;

/**
 * @author venkanna chowdary penubothu
 *
 */
public interface PlaneService {
	public void savePlane(Plane plane);

	public List<Plane> fetchAllPlanes();

	public List<Plane> fetchAllPlanesByStatus(String status);

	public Plane fetchPlaneById(long id);

	public void updatePlane(Plane plane);

	public void savePilot(Pilot pilot);

	public List<Pilot> fetchAllPilots();

	public Pilot fetchPilotById(long id);

	public void updatePilot(Pilot pilot);

	public void saveHanger(Hanger hanger);

	public List<Hanger> fetchAllHangers();

	public List<Hanger> fetchAllHangersByStatus(String status);

	public Hanger fetchHangerById(long id);

	public void updateHanger(Hanger hanger);
}
