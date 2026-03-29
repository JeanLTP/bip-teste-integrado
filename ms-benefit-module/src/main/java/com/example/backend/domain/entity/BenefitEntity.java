package com.example.backend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
@Table(name = "BENEFICIO")
public class BenefitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String name;

    @Column(name = "DESCRICAO")
    private String description;

    @Column(name = "VALOR")
    private BigDecimal value;

    @Column(name = "ATIVO")
    private boolean active;

    @Column(name = "VERSION")
    @Version
    private Long version;

    public void withdraw(BigDecimal amount) {
        if (this.value.compareTo(amount) < 0) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Saldo insuficiente para realizar a transferência."
            );
        }
        this.value = this.value.subtract(amount);
    }

    public void deposit(BigDecimal amount) {
        this.value = this.value.add(amount);
    }
}