package com.main.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.main.model.Pilot;
import com.main.model.Plane;
import com.main.model.Hanger;

/**
 * @author venkanna chowdary penubothu This PlaneDaoImpl contains methods that
 *         handles all plane requests from service layer and stores in database
 */
@Repository
public class PlaneDaoImpl implements PlaneDao {
	private static final Logger log = Logger.getLogger(PlaneDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savePlane(Plane plane) {
		// TODO Auto-generated method stub
		log.info("savePlane Dao");
		log.info(plane.toString());
		sessionFactory.getCurrentSession().save(plane);
	}

	@Override
	public List<Plane> fetchAllPlanes() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Plane plane");
		List<Plane> planeList = query.list();
		return planeList;
	}

	@Override
	public List<Plane> fetchAllPlanesByStatus(String status) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Plane.class);
		criteria.add(Restrictions.eq("status", status));
		List l = criteria.list();
		List<Plane> planeList = new ArrayList<>();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Plane plane = (Plane) it.next();
			planeList.add(plane);
		}
		return planeList;

	}

	@Override
	public Plane fetchPlaneById(long id) {
		// TODO Auto-generated method stub
		Plane plane = (Plane) sessionFactory.getCurrentSession().get(Plane.class, id);
		return plane;
	}

	@Override
	public void updatePlane(Plane plane) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(plane);
	}

	@Override
	public void savePilot(Pilot pilot) {
		// TODO Auto-generated method stub
		log.info("savePlane Dao");
		sessionFactory.getCurrentSession().save(pilot);
	}

	@Override
	public List<Pilot> fetchAllPilots() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Pilot pilot");
		List<Pilot> pilotList = query.list();
		return pilotList;
	}

	@Override
	public Pilot fetchPilotById(long id) {
		// TODO Auto-generated method stub
		Pilot pilot = (Pilot) sessionFactory.getCurrentSession().get(Pilot.class, id);
		return pilot;
	}

	@Override
	public void updatePilot(Pilot pilot) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(pilot);
	}

	@Override
	public void saveHanger(Hanger hanger) {
		// TODO Auto-generated method stub
		log.info("saveHanger Dao");
		sessionFactory.getCurrentSession().save(hanger);
	}

	@Override
	public List<Hanger> fetchAllHangers() {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().createQuery("from Hanger hanger");
		List<Hanger> hangerList = query.list();
		return hangerList;
	}

	@Override
	public List<Hanger> fetchAllHangersByStatus(String status) {
		// TODO Auto-generated method stub
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Hanger.class);
		criteria.add(Restrictions.eq("status", status));
		List l = criteria.list();
		List<Hanger> hangerList = new ArrayList<>();
		Iterator it = l.iterator();
		while (it.hasNext()) {
			Hanger hanger = (Hanger) it.next();
			hangerList.add(hanger);
		}
		return hangerList;

	}

	@Override
	public Hanger fetchHangerById(long id) {
		// TODO Auto-generated method stub
		Hanger hanger = (Hanger) sessionFactory.getCurrentSession().get(Hanger.class, id);
		return hanger;
	}

	@Override
	public void updateHanger(Hanger hanger) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(hanger);
	}

}
