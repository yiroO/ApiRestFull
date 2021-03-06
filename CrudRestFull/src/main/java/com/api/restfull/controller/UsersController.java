package com.api.restfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.restfull.dto.UsersDTO;
import com.api.restfull.dto.UsersResuest;
import com.api.restfull.entity.Users;
import com.api.restfull.service.UserService;
import com.api.restfull.utils.MessageErrors;
import com.api.restfull.utils.ValidationService;

@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/")
public class UsersController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ValidationService validationService;
	
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
	
	@PostMapping("/users")
	public ResponseEntity<Object> saveUser(@RequestBody UsersResuest usersreq) throws MessageErrors{
		this.validationService.validator(usersreq);
		this.userService.save(usersreq);
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	@PutMapping("/users/{id_user}")
	private ResponseEntity<Object> updateUser(@PathVariable Long id_user, @RequestBody UsersResuest req) {
		this.userService.update(id_user, req);
		return ResponseEntity.ok(Boolean.TRUE);
	}
	
	@DeleteMapping("/users/{id_user}")
	public ResponseEntity<Object> deleteUser(@PathVariable Long id_user) {
		this.userService.deleteById(id_user);
		return ResponseEntity.ok(Boolean.TRUE);
	}
}
