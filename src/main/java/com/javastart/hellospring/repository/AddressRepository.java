package com.javastart.hellospring.repository;

import com.javastart.hellospring.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}