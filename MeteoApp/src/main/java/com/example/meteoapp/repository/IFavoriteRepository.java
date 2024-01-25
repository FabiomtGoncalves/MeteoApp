package com.example.meteoapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.meteoapp.model.Favorite;

public interface IFavoriteRepository extends CrudRepository<Favorite, Long>{
	Favorite findByIdUserAndCodMunicip(Long idUser, String codMunicip);
	List<Favorite> findByIdUser(Long idUser);
}
