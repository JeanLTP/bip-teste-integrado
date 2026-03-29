package com.example.bff.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class BenefitDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal value;
    private boolean active;
    private Long version;
}