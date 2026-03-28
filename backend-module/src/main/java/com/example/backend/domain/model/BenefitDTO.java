package com.example.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitDTO {
    private Long id;
    private String name;
    private String description;
    private Long value;
    private boolean active;
    private Long version;
}