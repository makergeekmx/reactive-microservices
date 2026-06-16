package com.example.supplierservice.service;

import com.example.supplierservice.model.Supplier;
import com.example.supplierservice.model.SupplierOrder;
import com.example.supplierservice.repository.SupplierOrderRepository;
import com.example.supplierservice.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierOrderRepository orderRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Flux<Supplier> findAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Mono<Supplier> saveSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Mono<Void> deleteSupplier(Long id) {
        return supplierRepository.deleteById(id);
    }

    public Flux<SupplierOrder> findAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<SupplierOrder> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Flux<SupplierOrder> findOrdersBySupplier(Long supplierId) {
        return orderRepository.findBySupplierId(supplierId);
    }

    public Mono<SupplierOrder> saveOrder(SupplierOrder order) {
        return orderRepository.save(order)
                .doOnSuccess(saved -> kafkaTemplate.send("supplier-order", "Order arrived for supplier=" + saved.getSupplierId()));
    }

    public Mono<Void> deleteOrder(Long id) {
        return orderRepository.deleteById(id);
    }
}
