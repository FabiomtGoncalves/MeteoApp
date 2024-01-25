package com.example.meteoapp.model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.example.meteoapp.obj.Weather.ParentWeather;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WeatherModel {

	//List<Weather> weatherObjList = new ArrayList<Weather>();
	List<ParentWeather> weatherObjList = new ArrayList<ParentWeather>();
	
	public void testJson(String codProv, String codIne) {
		try {
			weatherObjList.clear();
			@SuppressWarnings("deprecation")
			URL urlObj = new URL("https://www.el-tiempo.net/api/json/v2/provincias/" + codProv + "/municipios/" + codIne);
			ObjectMapper objectMapper = new ObjectMapper();
            ParentWeather weather = objectMapper.readValue(urlObj, ParentWeather.class);
            //System.out.println(weather.getFecha());
            //getWeatherObj(weather);
            weatherObjList.add(weather);
		} catch (IOException e) {
			System.out.println("Erro: ");
			e.printStackTrace();
		}

	}
	
	public List<ParentWeather> getWeatherObj(){
		return weatherObjList;
	}
	
	
}
