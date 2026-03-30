package com.example.bff.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TransferRequestDTO {
    private Long fromId;
    private Long toId;
    private BigDecimal amount;
}

