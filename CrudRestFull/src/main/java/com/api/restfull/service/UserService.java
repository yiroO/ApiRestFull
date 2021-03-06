package com.api.restfull.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.api.restfull.dto.UsersDTO;
import com.api.restfull.dto.UsersResuest;

public interface UserService {
	
	List<UsersDTO> findAll();
	UsersDTO findByUsername(String username);
	//Optional<UsersDTO> findById(Long id_user);
	void save(UsersResuest usersreq);
	void update(Long id_user, UsersResuest usersreq);
	void deleteById(Long id_user);

}
