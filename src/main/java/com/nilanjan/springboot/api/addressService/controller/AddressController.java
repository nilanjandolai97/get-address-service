package com.nilanjan.springboot.api.addressService.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nilanjan.springboot.api.addressService.response.AddressResponse;
import com.nilanjan.springboot.api.addressService.service.AddressService;

@RestController
@RequestMapping("/v1")
public class AddressController {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	private AddressService service;
	
	@GetMapping("/studentaddress/{id}")
	public ResponseEntity<AddressResponse> findAddressByStudentId(@PathVariable int id){
		logger.debug("Entering into findAddressByStudentId.");
		logger.debug("id: ["+id+"]");	
		AddressResponse response = service.findAddressByStudentId(id);
		logger.debug("rsponse: [" + response.toString() + "]");	
		logger.debug("Going out from findAddressByStudentId.");	
		return ResponseEntity.ok(response);
	}
}
