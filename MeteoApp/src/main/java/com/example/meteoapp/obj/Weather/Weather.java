package com.example.meteoapp.obj.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

	private String fecha;
	private String[] stateSky;
	private String temperaturaActual;
	private String[] temperaturas;
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
    
	public String[] getStateSky() {
		return stateSky;
	}
    
	@JsonProperty("stateSky")
	public void setStateSky(String[] stateSky) {
		this.stateSky = stateSky;
	}
	
	public String getTemperaturaActual() {
		return temperaturaActual;
	}
    
	@JsonProperty("temperatura_actual")
    public void setTemperaturaActual(String temperaturaActual) {
		this.temperaturaActual = temperaturaActual;
	}
    
    public String[] getTemperaturas() {
		return temperaturas;
	}
    
    @JsonProperty("temperaturas")
    public void setTemperaturas(String[] temperaturas) {
		this.temperaturas = temperaturas;
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

	
}
