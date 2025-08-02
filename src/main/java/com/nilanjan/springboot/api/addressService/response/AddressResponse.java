package com.nilanjan.springboot.api.addressService.response;

public class AddressResponse {
	
	private Long student_id;
	private String street_address;
	private String city;
	private String state;
	private Long pin;
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	public String getStreet_address() {
		return street_address;
	}
	public void setStreet_address(String street_address) {
		this.street_address = street_address;
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
	public Long getPin() {
		return pin;
	}
	public void setPin(Long pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "AddressResponse [student_id=" + student_id + ", street_address=" + street_address + ", city=" + city
				+ ", state=" + state + ", pin=" + pin + "]";
	}
	
}
