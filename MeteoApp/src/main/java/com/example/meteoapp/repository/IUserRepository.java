package com.example.meteoapp.repository;


import org.springframework.data.repository.CrudRepository;
import com.example.meteoapp.model.User;

public interface IUserRepository extends CrudRepository<User, Long> {
	 User findByEmailAndPassword(String email, String password);
	 User findByEmail(String email);
}
