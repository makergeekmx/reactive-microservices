package com.example.inventoryservice.service;

import com.example.inventoryservice.model.InventoryItem;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Flux<InventoryItem> findAll() {
        return inventoryRepository.findAll();
    }

    public Mono<InventoryItem> findById(Long id) {
        return inventoryRepository.findById(id);
    }

    public Flux<InventoryItem> findByProductId(Long productId) {
        return inventoryRepository.findByProductId(productId);
    }

    public Mono<InventoryItem> save(InventoryItem item) {
        return inventoryRepository.save(item)
                .doOnSuccess(saved -> kafkaTemplate.send("inventory-update", "Inventory changed for product=" + saved.getProductId()));
    }

    public Mono<Void> delete(Long id) {
        return inventoryRepository.findById(id)
                .flatMap(item -> inventoryRepository.delete(item)
                        .doOnSuccess(unused -> kafkaTemplate.send("inventory-update", "Inventory removed product=" + item.getProductId())));
    }
}
