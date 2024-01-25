package com.example.meteoapp.obj.municipio;

import com.example.meteoapp.obj.Origen;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentMunicipio {

	 private Origen origen;
	 private Municipios[] municipios;

	 public Origen getOrigen() {
		 return origen;
	 }

	 public void setOrigen(Origen origen) {
		 this.origen = origen;
	 }

	 public Municipios[] getMunicipios() {
		 return municipios;
	 }

	 public void setMunicipios(Municipios[] municipios) {
		 this.municipios = municipios;
	 }
	
}
