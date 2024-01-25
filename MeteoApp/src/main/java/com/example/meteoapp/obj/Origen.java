package com.example.meteoapp.obj;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Origen {
	
	private String productor;
    private String web;
    
    public String getProductor() {
        return productor;
    }
    
    public void setProductor(String productor) {
        this.productor = productor;
    }
    
    public String getWeb() {
        return web;
    }
    
    public void setWeb(String web) {
        this.web = web;
    }

}
