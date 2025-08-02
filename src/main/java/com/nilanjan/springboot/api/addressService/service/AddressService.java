package com.nilanjan.springboot.api.addressService.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.nilanjan.springboot.api.addressService.controller.AddressController;
import com.nilanjan.springboot.api.addressService.exception.ResourceNotFoundException;
import com.nilanjan.springboot.api.addressService.model.StudentAddress;
import com.nilanjan.springboot.api.addressService.repo.StudentAddressRepository;
import com.nilanjan.springboot.api.addressService.response.AddressResponse;

@Service
public class AddressService {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
	
	@Autowired
	private StudentAddressRepository repo;
	@Autowired
	private ModelMapper mapper;
	
	public AddressResponse findAddressByStudentId(int id) {
		logger.debug("Entering into findAddressByStudentId.");
		logger.debug("id: ["+id+"]");
		StudentAddress addressResponse = repo.findById(id)
										     .orElseThrow(() -> new ResourceNotFoundException("Address not found for ID: " + id));
		AddressResponse response = mapper.map(addressResponse, AddressResponse.class);
		logger.debug("rsponse: [" + response.toString() + "]");	
		logger.debug("Going out from findAddressByStudentId.");	
		return response;
		
	}

}
