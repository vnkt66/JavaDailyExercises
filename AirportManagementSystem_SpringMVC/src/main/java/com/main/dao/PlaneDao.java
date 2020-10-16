package com.main.dao;

import com.main.model.Plane;
import com.main.model.Pilot;
import com.main.model.Hanger;

import java.util.List;

/**
 * @author venkanna chowdary penubothu
 *
 */
public interface PlaneDao {
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
