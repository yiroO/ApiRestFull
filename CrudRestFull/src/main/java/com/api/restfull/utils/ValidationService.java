package com.api.restfull.utils;

import org.springframework.stereotype.Service;

import com.api.restfull.dto.UsersResuest;

public interface ValidationService {

	void validator(UsersResuest userreq) throws MessageErrors;
}
