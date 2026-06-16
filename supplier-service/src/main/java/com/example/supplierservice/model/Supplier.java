package com.example.supplierservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("suppliers")
public class Supplier {
    @Id
    private Long id;

    @NotBlank
    private String name;

    private String contactEmail;
    private String contactPhone;
}
