package com.study.doctorhelper.model;

/**
 * Represents Address Model class
 * 
 * @author Komaljit.Singh
 */
public class Address {

	private String streetLine;
	private String city;
	private String state;
	private int pincode;
	private String country;
	
	public Address() {}
	
	/**
	 * @param streetLine
	 * @param city
	 * @param state
	 * @param pincode
	 * @param country
	 */
	public Address(String streetLine, String city, String state, int pincode, String country) {

		this.streetLine = streetLine;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
	}
	
	public String getStreetLine() {
		return streetLine;
	}
	
	public void setStreetLine(String streetLine) {
		this.streetLine = streetLine;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public int getPincode() {
		return pincode;
	}
	
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Address [streetLine=" + streetLine + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				+ ", country=" + country + "]";
	}	
}
