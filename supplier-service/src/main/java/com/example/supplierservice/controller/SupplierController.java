package com.example.supplierservice.controller;

import com.example.supplierservice.model.Supplier;
import com.example.supplierservice.model.SupplierOrder;
import com.example.supplierservice.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping
    public Flux<Supplier> getSuppliers() {
        return supplierService.findAllSuppliers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Supplier> createSupplier(@Valid @RequestBody Supplier supplier) {
        return supplierService.saveSupplier(supplier);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteSupplier(@PathVariable Long id) {
        return supplierService.deleteSupplier(id);
    }

    @GetMapping("/orders")
    public Flux<SupplierOrder> getOrders() {
        return supplierService.findAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Mono<SupplierOrder> getOrder(@PathVariable Long id) {
        return supplierService.findOrderById(id);
    }

    @GetMapping("/orders/supplier/{supplierId}")
    public Flux<SupplierOrder> getOrdersBySupplier(@PathVariable Long supplierId) {
        return supplierService.findOrdersBySupplier(supplierId);
    }

    @PostMapping("/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SupplierOrder> createOrder(@Valid @RequestBody SupplierOrder order) {
        return supplierService.saveOrder(order);
    }

    @DeleteMapping("/orders/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteOrder(@PathVariable Long id) {
        return supplierService.deleteOrder(id);
    }
}
