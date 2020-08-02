package com.api.restfull.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.hibernate.internal.util.MathHelper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.api.restfull.dto.UsersDTO;
import com.api.restfull.dto.UsersResuest;
import com.api.restfull.entity.Users;
import com.api.restfull.repository.UserRepository;
import com.api.restfull.service.UserService;
import com.api.restfull.utils.MHelpers;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UsersDTO> findAll() {
		List<UsersDTO> dto = new ArrayList<>();
		Iterable<Users> user = this.userRepository.findAll();
		for (Users users : user) {
			UsersDTO usersDTO = MHelpers.modelMapper().map(users, UsersDTO.class);
			dto.add(usersDTO);
		}
		return dto;
	}

	@Override
	public UsersDTO findByUsername(String username) {
		Optional<Users> us = this.userRepository.findByUsername(username);
		if(!us.isPresent()) {
			return null;
		}
		return MHelpers.modelMapper().map(us.get(), UsersDTO.class);
	}

	@Override
	public Optional<UsersDTO> findById(Long id_user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UsersResuest usersreq) {
		Users us = MHelpers.modelMapper().map(usersreq, Users.class);
		this.userRepository.save(us);
	}

	@Override
	public void saveAll(UsersResuest usersreq) {
		List<Users> us = new ArrayList<Users>();
		
		for (Users users : us) {
			Users usrs = MHelpers.modelMapper().map(users, Users.class);
			us.add(usrs);
		}
		this.userRepository.saveAll(us);
	}

	@Override
	public void deleteById(Long id_user) {
		// TODO Auto-generated method stub

	}

	private UsersDTO convertToUsersDTO(final Users user) {
		return MHelpers.modelMapper().map(user, UsersDTO.class);
	}

}
