package com.example.meteoapp.model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.example.meteoapp.obj.provincia.ParentProvincia;
import com.example.meteoapp.obj.provincia.Provincias;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProvinciaModel {

	List<Provincias> provObjList = new ArrayList<Provincias>();
	
	public void load(){
		provObjList.clear();
		try {
			@SuppressWarnings("deprecation")
			URL urlObj = new URL("https://www.el-tiempo.net/api/json/v2/provincias");
	        ObjectMapper objectMapper = new ObjectMapper();
            ParentProvincia provincia = objectMapper.readValue(urlObj, ParentProvincia.class);
            System.out.println(provincia.getProvincias());
            printParsedObject(provincia);
            /*for(String prov : provinceList) {
            	System.out.println(prov);
            }*/
        } catch (IOException e) {
			System.out.println("Erro: ");
            e.printStackTrace();
        }
	}
	

	
	public List<Provincias> getProvObj(){
		return provObjList;
	}
	
	
	private void printParsedObject(ParentProvincia provincia) {
		//printOrigenInfo(provincia.getOrigen());
        printProvincias(provincia.getProvincias());
    }
	
	/*private static void printOrigenInfo(Origen origen) {
        System.out.println("Origen Info:");
        System.out.println("**********");
        System.out.println("\tProductor: " + origen.getProductor());
        System.out.println("\tWeb: " + origen.getWeb());
    }*/
	
	private void printProvincias(Provincias[] provincias) {
        //System.out.println("Provincias:");
        //System.out.println("**********");
        for(Provincias post : provincias) {
        	printProvincia(post);
        }
    }
    
	public String printProvincia(Provincias provincia) {
		provObjList.add(provincia);
        return provincia.getNombreProvincia();
        //provinceList.add(provincia.getNombreProvincia());
        //codProvList.add(provincia.getCodProv());
        //System.out.println("\tCOD PROV: " + provincia.getCodProv());
        //System.out.println("\tNome Provincia: " + provincia.getNombreProvincia());
        //System.out.println("\tCODAUTON: " + provincia.getCodAuton());
        //System.out.println("\tComunidade: " + provincia.getComunidadCiudadAutonoma());
        //System.out.println("\tCapital: " + provincia.getCapitalProvincia());
    }
	
}
