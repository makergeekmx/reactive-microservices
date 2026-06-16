package com.example.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("inventory_items")
public class InventoryItem {
    @Id
    private Long id;
    private Long productId;
    private Integer quantity;
    private String location;
}
