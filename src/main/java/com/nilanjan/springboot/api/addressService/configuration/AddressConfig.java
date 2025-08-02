package com.nilanjan.springboot.api.addressService.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.*;

@Configuration
public class AddressConfig {

	@Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }
}
