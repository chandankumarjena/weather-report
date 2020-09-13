package com.weather.weatherrport.model;

import java.util.List;

public class WeatherDetails {
	private String dt;
	private List<Weather> weather;
	private Temperature main;
	private String dt_txt;
	
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public List<Weather> getWeather() {
		return weather;
	}
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}
	public Temperature getMain() {
		return main;
	}
	public void setMain(Temperature main) {
		this.main = main;
	}
	public String getDt_txt() {
		return dt_txt;
	}
	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}
}