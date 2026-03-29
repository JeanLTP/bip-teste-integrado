package com.example.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class BenefitDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal value;
    private boolean active;
    private Long version;
}