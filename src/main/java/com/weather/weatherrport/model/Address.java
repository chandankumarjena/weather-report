package com.weather.weatherrport.model;

public class Address {
	private long id;
	private String name;
	private String country;
	private CoOrdinate coord;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public CoOrdinate getCoord() {
		return coord;
	}
	public void setCoord(CoOrdinate coord) {
		this.coord = coord;
	}

}