package com.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

/**
 * @author venkanna chowdary penubothu This model class refers to plane Table in
 *         database named hibernate
 */
@Entity
@DynamicUpdate
@Table(name = "Plane")
public class Plane {
	@Id
	private Long planeId;
	@NotNull
	private Double travelSpeed;
	@NotNull
	private Double flyHours;
	@NotNull
	private Double consumption;
	@NotNull
	private Double maxFuel;
	@NotNull
	private Double kerosinStorage;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pilotId")
	private Pilot pilot;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "hangerId")
	private Hanger hanger;
	private String status;

	public Long getPlaneId() {
		return planeId;
	}

	public void setPlaneId(Long planeId) {
		this.planeId = planeId;
	}

	public Double getTravelSpeed() {
		return travelSpeed;
	}

	public void setTravelSpeed(Double travelSpeed) {
		this.travelSpeed = travelSpeed;
	}

	public Double getFlyHours() {
		return flyHours;
	}

	public void setFlyHours(Double flyHours) {
		this.flyHours = flyHours;
	}

	public Double getConsumption() {
		return consumption;
	}

	public void setConsumption(Double consumption) {
		this.consumption = consumption;
	}

	public Double getMaxFuel() {
		return maxFuel;
	}

	public void setMaxFuel(Double maxFuel) {
		this.maxFuel = maxFuel;
	}

	public Double getKerosinStorage() {
		return kerosinStorage;
	}

	public void setKerosinStorage(Double kerosinStorage) {
		this.kerosinStorage = kerosinStorage;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public Hanger getHanger() {
		return hanger;
	}

	public void setHanger(Hanger hanger) {
		this.hanger = hanger;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
