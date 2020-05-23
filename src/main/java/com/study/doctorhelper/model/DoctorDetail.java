package com.study.doctorhelper.model;

import java.time.ZonedDateTime;

/**
 * Represents Doctor Detail Model class
 * 
 * @author Komaljit.Singh
 */
public class DoctorDetail {

	private long doctorId;
	private String doctorName;
	private String mobileNo;
	private String email;
	private ZonedDateTime dob;
	private String department;
	private String qualification;
	private String password;
	private Gender gender;
	private int status;
	private Address address;
	private String Specialist;
	private int yearOfExperience;
	
	public DoctorDetail() {}

	/**
	 * @param doctorId
	 * @param doctorName
	 * @param mobileNo
	 * @param email
	 * @param dob
	 * @param department
	 * @param qualification
	 * @param password
	 * @param gender
	 * @param status
	 * @param address
	 * @param specialist
	 * @param yearOfExperience
	 */
	public DoctorDetail(long doctorId, String doctorName, String mobileNo, String email, ZonedDateTime dob,
			String department, String qualification, String password, Gender gender, int status, Address address,
			String specialist, int yearOfExperience) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.dob = dob;
		this.department = department;
		this.qualification = qualification;
		this.password = password;
		this.gender = gender;
		this.status = status;
		this.address = address;
		Specialist = specialist;
		this.yearOfExperience = yearOfExperience;
	}



	public long getDoctorId() {
		return doctorId;
	}
	
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	
	public String getDoctorName() {
		return doctorName;
	}
	
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	public String getMobileNo() {
		return mobileNo;
	}
	
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public ZonedDateTime getDob() {
		return dob;
	}

	public void setDob(ZonedDateTime dob) {
		this.dob = dob;
	}

	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String getQualification() {
		return qualification;
	}
	
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getSpecialist() {
		return Specialist;
	}

	public void setSpecialist(String specialist) {
		Specialist = specialist;
	}

	public int getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	@Override
	public String toString() {
		return "DoctorDetail [doctorId=" + doctorId + ", doctorName=" + doctorName + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", dob=" + dob + ", department=" + department + ", qualification="
				+ qualification + ", password=" + password + ", gender=" + gender + ", status=" + status + ", address="
				+ address + ", Specialist=" + Specialist + ", yearOfExperience=" + yearOfExperience + "]";
	}
}
