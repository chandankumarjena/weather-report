package com.weather.weatherrport.model;

import java.math.BigDecimal;

public class CoOrdinate {
	private BigDecimal lat;
	private BigDecimal lon;
	public BigDecimal getLat() {
		return lat;
	}
	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}
	public BigDecimal getLon() {
		return lon;
	}
	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}
}
