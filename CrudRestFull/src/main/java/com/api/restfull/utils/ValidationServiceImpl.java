package com.api.restfull.utils;

import org.springframework.stereotype.Service;

import com.api.restfull.dto.UsersResuest;

@Service
public class ValidationServiceImpl implements ValidationService{

	@Override
	public void validator(UsersResuest userreq) throws MessageErrors {
		
		if(userreq.getFirstname() == null || userreq.getFirstname().isEmpty()) {
			this.message("El nombre del usuario es obligatorio");
		}
		if(userreq.getFirstname().length() < 3) {
			message("El nombre es muy corto, debe contener minimo 3 caracteres");
		}
		if(userreq.getLastname() == null || userreq.getLastname().isEmpty()) {
			this.message("El apellido del usuario es obligatorio");
		}
		if(userreq.getLastname().length() < 3) {
			message("El apellido es muy corto, debe contener minimo 3 caracteres");
		}
		if(userreq.getUsername() == null || userreq.getUsername().isEmpty()) {
			this.message("El username del usuario es obligatorio");
		}
		if(userreq.getUsername().length() < 3) {
			message("El username es muy corto, debe contener minimo 3 caracteres");
		}
	}

	private void message(String message) throws MessageErrors {
		throw new MessageErrors(message);
	}
	

}
