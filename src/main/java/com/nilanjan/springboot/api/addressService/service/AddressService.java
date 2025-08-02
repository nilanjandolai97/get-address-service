package com.nilanjan.springboot.api.addressService.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import com.nilanjan.springboot.api.addressService.exception.ResourceNotFoundException;
import com.nilanjan.springboot.api.addressService.model.StudentAddress;
import com.nilanjan.springboot.api.addressService.repo.StudentAddressRepository;
import com.nilanjan.springboot.api.addressService.response.AddressResponse;

@Service
public class AddressService {
	
	@Autowired
	private StudentAddressRepository repo;
	@Autowired
	private ModelMapper mapper;
	
	public AddressResponse findAddressByStudentId(int id) {
		StudentAddress addressResponse = repo.findById(id)
										     .orElseThrow(() -> new ResourceNotFoundException("Address not found for ID: " + id));
		AddressResponse response = mapper.map(addressResponse, AddressResponse.class);
		return response;
		
	}

}
