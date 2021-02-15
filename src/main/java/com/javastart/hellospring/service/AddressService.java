package com.javastart.hellospring.service;

import com.javastart.hellospring.entity.Address;
import com.javastart.hellospring.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {

    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void createAddress(Address address){
        addressRepository.save(address);
    }

    @Transactional
    public void deleteAddress(Address address){
        addressRepository.delete(address);
    }
// Further we can write other methods
}