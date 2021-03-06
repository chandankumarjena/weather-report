package com.weather.weatherrport.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.weatherrport.model.DailyFortune;
import com.weather.weatherrport.model.WeatherDescription;
import com.weather.weatherrport.model.WeatherDetails;



@Service
public class WeatherService {
    private final String URI = "https://samples.openweathermap.org/data/2.5/forecast";
    private final String API_ID = "d2929e9483efc82c82c32ee7%20e02d563e";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
    
    public List<DailyFortune> weatherForecast(String city) {
    	WeatherDescription weatherMap =
          this.restTemplate.getForObject(this.url(city), WeatherDescription.class);
    	List<DailyFortune> dailyFortunes =  new LinkedList<DailyFortune>();
    	List<WeatherDetails> weatherDetails = weatherMap.getList();
    	
    	for(WeatherDetails weatherDetail : weatherDetails) {
    		DailyFortune df = new DailyFortune();
    		df.setDateTime(weatherDetail.getDt_txt());
    		df.setMax_temp(weatherDetail.getMain().getTemp_max());
    		df.setClimate(weatherDetail.getWeather().get(0).getMain());
    		df.setClimateDescription(weatherDetail.getWeather().get(0).getDescription());
    		if(weatherDetail.getWeather().get(0).getMain().contains("Rain")) {
    			df.setFortuneMessage("carry umbrela");
    		} else if(weatherDetail.getMain().getTemp_max().compareTo(new BigDecimal("313")) == 1) {
    			df.setFortuneMessage("Use sunscreen lotion");
    		} 
    		dailyFortunes.add(df);
    	}
    	return dailyFortunes;
    }
    
    public List<DailyFortune> weatherForecastByDay(String city, int whichDay) {
    	WeatherDescription weatherMap =
          this.restTemplate.getForObject(this.url(city), WeatherDescription.class);
    	List<DailyFortune> dailyFortunes = null;
    	List<WeatherDetails> weatherDetails = weatherMap.getList();
    	int totalData = weatherDetails.size();
    	if(totalData == 36) {
    		if(whichDay == 1) {
    			dailyFortunes = getFortunes(weatherDetails.subList(0, 8));
    		} else if(whichDay == 2) {
    			dailyFortunes = getFortunes(weatherDetails.subList(9, 17));
    		} else if(whichDay == 3) {
    			dailyFortunes = getFortunes(weatherDetails.subList(18, 27));
    		} else if(whichDay == 4) {
    			dailyFortunes = getFortunes(weatherDetails.subList(28, 35));
    		} else {
    			dailyFortunes = new LinkedList<DailyFortune>();
    		}
    	} else {
    		dailyFortunes =  getFortunes(weatherDetails);
    	}
    	return dailyFortunes;
    }

    private List<DailyFortune> getFortunes(List<WeatherDetails> weatherDetails) {
		List<DailyFortune> dailyFortunes = new LinkedList<DailyFortune>();
    	for(WeatherDetails weatherDetail : weatherDetails) {
    		DailyFortune df = new DailyFortune();
    		df.setDateTime(weatherDetail.getDt_txt());
    		df.setMax_temp(weatherDetail.getMain().getTemp_max());
    		df.setClimate(weatherDetail.getWeather().get(0).getMain());
    		df.setClimateDescription(weatherDetail.getWeather().get(0).getDescription());
    		if(weatherDetail.getWeather().get(0).getMain().contains("Rain")) {
    			df.setFortuneMessage("carry umbrela");
    		} else if(weatherDetail.getMain().getTemp_max().compareTo(new BigDecimal("313")) == 1) {
    			df.setFortuneMessage("Use sunscreen lotion");
    		} 
    		dailyFortunes.add(df);
    	}
		return dailyFortunes;
	}

	private String url(String city) {
        return String.format(URI.concat("?q=%s").concat("&appid=%s"), city, API_ID);
    }
}
