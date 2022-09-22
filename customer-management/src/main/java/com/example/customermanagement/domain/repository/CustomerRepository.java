package com.example.customermanagement.domain.repository;

import com.example.customermanagement.domain.models.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
}
