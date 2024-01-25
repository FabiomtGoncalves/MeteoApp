package com.example.meteoapp.obj.provincia;

import com.example.meteoapp.obj.Origen;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParentProvincia {

	 private Origen origen;
	 private Provincias[] provincias;

	 public Origen getOrigen() {
		 return origen;
	 }

	 public void setOrigen(Origen origen) {
		 this.origen = origen;
	 }

	 public Provincias[] getProvincias() {
		 return provincias;
	 }

	 public void setProvincias(Provincias[] provincias) {
		 this.provincias = provincias;
	 }
	
}
