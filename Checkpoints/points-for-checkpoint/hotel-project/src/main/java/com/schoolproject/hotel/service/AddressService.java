package com.schoolproject.hotel.service;

import com.schoolproject.hotel.controller.dto.AddressCreationRequest;
import com.schoolproject.hotel.mapper.AddressMapper;
import com.schoolproject.hotel.model.AddressEntity;
import com.schoolproject.hotel.repository.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public AddressEntity saveAddress(AddressCreationRequest req){
        AddressEntity address = AddressMapper.convertDTOToDomainObj(req);
        return repository.save(address);
    }
}
