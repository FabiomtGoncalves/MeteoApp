package com.example.meteoapp.model;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.example.meteoapp.obj.municipio.Municipios;
import com.example.meteoapp.obj.municipio.ParentMunicipio;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MunicipioModel {

	List<Municipios> municipObjList = new ArrayList<Municipios>();

	public void load(String codProv){
		municipObjList.clear();
		try {
			@SuppressWarnings("deprecation")
			URL urlObj = new URL("https://www.el-tiempo.net/api/json/v2/provincias/" + codProv + "/municipios");
	        ObjectMapper objectMapper = new ObjectMapper();
            ParentMunicipio municipio = objectMapper.readValue(urlObj, ParentMunicipio.class);
            printParsedObject(municipio);
        } catch (IOException e) {
			System.out.println("Erro: ");
            e.printStackTrace();
        }
	}
	
	
	public List<Municipios> getMunicipObj(){
		return municipObjList;
	}
	
	private void printParsedObject(ParentMunicipio municipio) {
        printMunicipios(municipio.getMunicipios());
    }
	
	private void printMunicipios(Municipios[] municipios) {
        for(Municipios municipio : municipios) {
        	printMunicipio(municipio);
        }
    }
    
	public String printMunicipio(Municipios municipio) {
		municipObjList.add(municipio);
        return municipio.getNombre();
    }
	
}
