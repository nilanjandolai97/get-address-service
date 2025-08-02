package com.nilanjan.springboot.api.addressService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nilanjan.springboot.api.addressService.response.AddressResponse;
import com.nilanjan.springboot.api.addressService.service.AddressService;

@RestController
@RequestMapping("/v1")
public class AddressController {
	@Autowired
	private AddressService service;
	
	@GetMapping("/studentaddress/{id}")
	public ResponseEntity<AddressResponse> getAddressByEmployeeId(@PathVariable int id){
		AddressResponse response = service.findAddressByStudentId(id);
		return ResponseEntity.ok(response);
		
	}
}
