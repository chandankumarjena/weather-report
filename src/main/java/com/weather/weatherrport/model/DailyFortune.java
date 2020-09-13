package com.weather.weatherrport.model;

import java.math.BigDecimal;

public class DailyFortune {
	private String dateTime;
	private BigDecimal max_temp;
	private String climate;
	private String fortuneMessage;
	private String climateDescription;
	
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public BigDecimal getMax_temp() {
		return max_temp;
	}
	public void setMax_temp(BigDecimal max_temp) {
		this.max_temp = max_temp;
	}
	public String getClimate() {
		return climate;
	}
	public void setClimate(String climate) {
		this.climate = climate;
	}
	public String getFortuneMessage() {
		return fortuneMessage;
	}
	public void setFortuneMessage(String fortuneMessage) {
		this.fortuneMessage = fortuneMessage;
	}
	public String getClimateDescription() {
		return climateDescription;
	}
	public void setClimateDescription(String climateDescription) {
		this.climateDescription = climateDescription;
	}
}