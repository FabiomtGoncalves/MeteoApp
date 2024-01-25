package com.example.meteoapp.obj.Weather;

import com.example.meteoapp.obj.Origen;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentWeather {

	private Origen origin;
	//private Municipio[] municipio;
	private String fecha;
	private String temperaturaActual;
	private String humedad;
	private String viento;
	private String lluvia;
	private String precipitacion;

	public String getFecha() {
		return fecha;
	}

	@JsonProperty("fecha")
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/*public Municipio[] getMunicipio() {
		return municipio;
	}

	@JsonProperty("municipio")
	public void getMunicipio(Municipio[] municipio) {
		this.municipio = municipio;
	}*/
	

	public String getTemperaturaActual() {
		return temperaturaActual;
	}

	@JsonProperty("temperatura_actual")
	public void setTemperaturaActual(String temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
	}

	
	public String getHumedad() {
		return humedad;
	}

	@JsonProperty("humedad")
	public void setHumedad(String humedad) {
		this.humedad = humedad;
	}

	public String getViento() {
		return viento;
	}

	@JsonProperty("viento")
	public void setViento(String viento) {
		this.viento = viento;
	}

	public String getLluvia() {
		return lluvia;
	}

	@JsonProperty("lluvia")
	public void setLluvia(String lluvia) {
		this.lluvia = lluvia;
	}

	public String getPrecipitacion() {
		return precipitacion;
	}

	@JsonProperty("precipitacion")
	public void setPrecipitacion(String precipitacion) {
		this.precipitacion = precipitacion;
	}

	public Origen getOrigin() {
		return origin;
	}

	public void setOrigin(Origen origin) {
		this.origin = origin;
	}


}
