package com.example.supplierservice.repository;

import com.example.supplierservice.model.Supplier;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SupplierRepository extends ReactiveCrudRepository<Supplier, Long> {
}
