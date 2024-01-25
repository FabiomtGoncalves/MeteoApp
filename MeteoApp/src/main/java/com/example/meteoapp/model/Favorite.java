package com.example.meteoapp.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Favorite")
public class Favorite {

	@Id
    @GeneratedValue
    private Long idFav;
    
	private String codProv;
	
	private String codMunicip;
	
	private Long idUser;
	
	private String nameProvincia;
	
	private String nameMunicipio;
	
	@ManyToMany(mappedBy = "favMunicip")
	Set<User> favs;
	
	public Favorite() {
    }

    public Favorite(String codProv, String codMunicip, Long idUser, String nameProvincia, String nameMunicipio) {
        this.codProv = codProv;
        this.codMunicip = codMunicip;
        this.idUser = idUser;
        this.nameProvincia = nameProvincia;
        this.nameMunicipio = nameMunicipio;
    }
    
	public Long getIdFav() {
		return idFav;
	}
	
	public void setIdFav(Long idFav) {
		this.idFav = idFav;
	}
	
	public Long getIdUser() {
		return idUser;
	}
	
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	
	public String getCodProv() {
		return codProv;
	}
	
	public void setCodProv(String codProv) {
		this.codProv = codProv;
	}
	
	
	public String getCodMunicip() {
		return codMunicip;
	}
	
	public void setCodMunicip(String codMunicip) {
		this.codMunicip = codMunicip;
	}
	
	public String getNameProvincia() {
		return nameProvincia;
	}
	
	public void setNameProvincia(String nameProvincia) {
		this.nameProvincia = nameProvincia;
	}
	
	public String getNameMunicipio() {
		return nameMunicipio;
	}
	
	public void setNameMunicipio(String nameMunicipio) {
		this.nameMunicipio = nameMunicipio;
	}
	
	
	  @Override
	    public String toString() {
	        return "Favorite{" +
	                "idFav=" + idFav +
	                ", codProv='" + codProv + '\'' +
	                ", codMunicip=" + codMunicip + '\'' +
	                ", idUser=" + idUser + '\'' +
	                ", nameProvincia=" + nameProvincia + '\'' +
	                ", nameMunicipio=" + nameMunicipio +
	                '}';
	    }
	
}
