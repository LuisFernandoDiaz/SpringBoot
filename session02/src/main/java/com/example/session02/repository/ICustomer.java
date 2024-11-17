package com.example.session02.repository;

import com.example.session02.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomer extends CrudRepository<Customer, Integer> {
}
