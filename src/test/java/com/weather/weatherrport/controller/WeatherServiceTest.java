package com.weather.weatherrport.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.weather.weatherrport.service.WeatherService;

@SpringBootTest
public class WeatherServiceTest {

	@Autowired
	private WeatherService weatherService;
	
	public void testWeatherForeCast_returnExpectedResult() {
		assertEquals(36,weatherService.weatherForecast("London").size());
	}
	
	public void testWeatherForeCastByDay_returnExpectedResult() {
		assertEquals(8,weatherService.weatherForecastByDay("London",1).size());
	}
}
