package com.sidneyspe.service;

import com.sidneyspe.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerService extends JpaRepository<Customer, Long> {
    List<Customer> findByName(String name);
}
