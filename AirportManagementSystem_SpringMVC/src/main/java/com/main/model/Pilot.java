package com.main.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author venkanna chowdary penubothu This model class refers to pilot Table in
 *         database named hibernate
 */
@Entity
@Table(name = "Pilot")
public class Pilot {
	@Id
	private Long pilotId;
	@NotEmpty
	@Size(min = 6, max = 20)
	private String name;
	@NotNull
	@Min(value = 18)
	@Max(value = 45)
	private Integer age;
	@Enumerated(value = EnumType.STRING)
	private Gender gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	private Date dob;
	@NotNull
//	@Transient
	private Long planeIdRef;
	@OneToOne(mappedBy = "pilot")
	private Plane plane;

	public Long getPilotId() {
		return pilotId;
	}

	public void setPilotId(Long pilotId) {
		this.pilotId = pilotId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

}
