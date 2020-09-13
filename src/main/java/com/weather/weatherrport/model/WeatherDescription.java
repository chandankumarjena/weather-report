package com.weather.weatherrport.model;

import java.math.BigDecimal;
import java.util.List;

public class WeatherDescription {
	private String cod;
	private BigDecimal message;
	private Integer cnt;
	private Address city;
	private List<WeatherDetails> list;
    
	public String getCod() {
		return cod;
	}

	public void setCod(String code) {
		this.cod = code;
	}

	public BigDecimal getMessage() {
		return message;
	}

	public void setMessage(BigDecimal message) {
		this.message = message;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public Address getCity() {
		return city;
	}

	public void setCity(Address city) {
		this.city = city;
	}

	public List<WeatherDetails> getList() {
		return list;
	}

	public void setList(List<WeatherDetails> list) {
		this.list = list;
	}
}