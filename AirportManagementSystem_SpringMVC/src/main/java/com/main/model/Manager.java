package com.main.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author venkanna chowdary penubothu This model class refers to manager Table
 *         in database named hibernate
 */
@Entity
@Table(name = "Manager")
public class Manager {
	@Id
	private Long managerId;
	@NotEmpty
	@Size(min = 4, max = 20)
	private String firstName;
	@NotEmpty
	@Size(min = 4, max = 20)
	private String lastName;
	@NotNull
	@Min(value = 18)
	@Max(value = 45)
	private Integer age;
	@Enumerated(value = EnumType.STRING)
	private Gender gender;
	@NotEmpty
	@Size(min = 10, max = 15)
	private String contactNumber;
	@NotEmpty
	@Size(min = 6, max = 15)
	private String password;

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
