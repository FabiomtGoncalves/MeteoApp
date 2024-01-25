package com.example.meteoapp.obj.provincia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Provincias {

	private String codProv;
	private String nombreProvincia;
	private String codAuton;
	private String comunidadCiudadAutonoma;
	private String capitalProvincia;

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
	
	public String getCodAuton() {
		return codAuton;
	}
    
	@JsonProperty("CODAUTON")
    public void setCodAuton(String codAuton) {
		this.codAuton = codAuton;
	}
    
    public String getComunidadCiudadAutonoma() {
		return comunidadCiudadAutonoma;
	}
    
    @JsonProperty("COMUNIDAD_CIUDAD_AUTONOMA")
    public void setComunidadCiudadAutonoma(String comunidadCiudadAutonoma) {
		this.comunidadCiudadAutonoma = comunidadCiudadAutonoma;
	}

	public String getCapitalProvincia() {
		return capitalProvincia;
	}
	
	@JsonProperty("CAPITAL_PROVINCIA")
	public void setCapitalProvincia(String capitalProvincia) {
		this.capitalProvincia = capitalProvincia;
	}


	
}
