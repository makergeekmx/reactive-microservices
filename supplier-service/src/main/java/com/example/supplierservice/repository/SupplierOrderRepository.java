package com.example.supplierservice.repository;

import com.example.supplierservice.model.SupplierOrder;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface SupplierOrderRepository extends ReactiveCrudRepository<SupplierOrder, Long> {
    Flux<SupplierOrder> findBySupplierId(Long supplierId);
}
