package com.example.supplierservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("supplier_orders")
public class SupplierOrder {
    @Id
    private Long id;
    private Long supplierId;
    private Long productId;
    private Integer quantity;
    private LocalDate expectedDate;
    private String status;
}
