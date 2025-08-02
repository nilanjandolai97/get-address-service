package com.nilanjan.springboot.api.addressService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.nilanjan.springboot.api.addressService.model.StudentAddress;
import com.nilanjan.springboot.api.addressService.repo.StudentAddressRepository;
import com.nilanjan.springboot.api.addressService.response.AddressResponse;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
	@InjectMocks
    private AddressService addressService;

    @Mock
    private StudentAddressRepository repo;

    @Mock
    private ModelMapper mapper;

    @Test
    void testFindAddressByStudentId() {
        int id = 1;
        StudentAddress address = new StudentAddress();
        address.setCity("Kolkata");
        //address.setStudent_id(id);

        AddressResponse mockResponse = new AddressResponse();
        mockResponse.setCity("Kolkata");
		/*
		 * mockResponse.setStudent_id(id); System.out.println(id);
		 */
        
        Mockito.when(repo.findById(id)).thenReturn(Optional.of(address));
        Mockito.when(mapper.map(address, AddressResponse.class)).thenReturn(mockResponse);
        
        //System.out.println(id);
        AddressResponse response = addressService.findAddressByStudentId(id);
        //System.out.println(response.toString());
        assertNotNull(response);
        System.out.println(response.toString());
        assertEquals("Kolkata", response.getCity());
    }
}
