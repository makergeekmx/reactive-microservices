package com.example.inventoryservice.controller;

import com.example.inventoryservice.model.InventoryItem;
import com.example.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    public Flux<InventoryItem> getAll() {
        return inventoryService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<InventoryItem> getById(@PathVariable Long id) {
        return inventoryService.findById(id);
    }

    @GetMapping("/product/{productId}")
    public Flux<InventoryItem> getByProduct(@PathVariable Long productId) {
        return inventoryService.findByProductId(productId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<InventoryItem> create(@Valid @RequestBody InventoryItem item) {
        return inventoryService.save(item);
    }

    @PutMapping("/{id}")
    public Mono<InventoryItem> update(@PathVariable Long id, @Valid @RequestBody InventoryItem item) {
        item.setId(id);
        return inventoryService.save(item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable Long id) {
        return inventoryService.delete(id);
    }
}
