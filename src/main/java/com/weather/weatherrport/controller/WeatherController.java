package com.weather.weatherrport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.weatherrport.model.DailyFortune;
import com.weather.weatherrport.service.WeatherService;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    //all 4 days details
    @GetMapping(value = "/forecast/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  List<DailyFortune> getWeatherForFourDays(@PathVariable String city) {
    	return weatherService.weatherForecast(city);
    }
    
    //1-4 four individual days
    @GetMapping(value = "/forecast/{city}/{whichDay}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  List<DailyFortune> getWeather(@PathVariable String city,
    		@PathVariable int whichDay) {
    	return weatherService.weatherForecastByDay(city, whichDay);
    }
}