package com.nilanjan.springboot.api.addressService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nilanjan.springboot.api.addressService.model.StudentAddress;

public interface StudentAddressRepository extends JpaRepository<StudentAddress, Integer>{

}
