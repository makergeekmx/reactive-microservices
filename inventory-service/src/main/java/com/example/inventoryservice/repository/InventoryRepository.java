package com.example.inventoryservice.repository;

import com.example.inventoryservice.model.InventoryItem;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface InventoryRepository extends ReactiveCrudRepository<InventoryItem, Long> {
    Flux<InventoryItem> findByProductId(Long productId);
}
