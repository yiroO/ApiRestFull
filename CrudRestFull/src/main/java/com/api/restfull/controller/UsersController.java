package com.api.restfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.restfull.dto.UsersDTO;
import com.api.restfull.entity.Users;
import com.api.restfull.service.UserService;

@RestController
@RequestMapping("/")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<Object> findAll(){
		return ResponseEntity.ok(this.userService.findAll());
	}
	
	@GetMapping("/users/{username}")
	public ResponseEntity<UsersDTO> findByUserName(@PathVariable String username) {
		UsersDTO us = this.userService.findByUsername(username);
		if(us == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(us);
	}
}