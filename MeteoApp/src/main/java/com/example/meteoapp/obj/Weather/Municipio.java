package com.example.meteoapp.obj.Weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Municipio {
	private String codigoIne;
	private String codProv;
	private String nombreProvincia;
	private String nombre;
	private String poblacionCapital;

	public String getCodigoIne() {
		return codigoIne;
	}

	@JsonProperty("CODIGOINE")
	public void setCodigoIne(String codigoIne) {
		this.codigoIne = codigoIne;
	}

	public String getCodProv() {
		return codProv;
	}

	@JsonProperty("CODPROV")
	public void setCodProv(String codProv) {
		this.codProv = codProv;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	@JsonProperty("NOMBRE_PROVINCIA")
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	@JsonProperty("NOMBRE")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacionCapital() {
		return poblacionCapital;
	}

	@JsonProperty("POBLACION_CAPITAL")
	public void setPoblacionCapital(String poblacionCapital) {
		this.poblacionCapital = poblacionCapital;
	}
}
