package com.api.restfull.utils;

import org.modelmapper.ModelMapper;

/**
 * @apiNote Sirve para convertir de una entidad a un dto y viceversa.
 * 
 * **/
public class MHelpers {

	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
