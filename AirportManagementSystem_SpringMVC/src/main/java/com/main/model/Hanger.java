package com.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author venkanna chowdary penubothu This model class refers to hanger Table
 *         in database named hibernate
 */
@Entity
@Table(name = "Hanger")
public class Hanger {
	@Id
	private Long hangerId;
	@NotEmpty
	private String name;
	@NotEmpty
	private String location;
	private String status;
//	@Transient
	private Long planeIdRef;
	@OneToOne(mappedBy = "hanger")
	private Plane plane;

	public Long getHangerId() {
		return hangerId;
	}

	public void setHangerId(Long hangerId) {
		this.hangerId = hangerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public Long getPlaneIdRef() {
		return planeIdRef;
	}

	public void setPlaneIdRef(Long planeIdRef) {
		this.planeIdRef = planeIdRef;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
