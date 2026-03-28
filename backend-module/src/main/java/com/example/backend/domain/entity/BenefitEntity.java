package com.example.backend.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "BENEFITS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BenefitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String name;

    @Column(name = "DESCRICAO")
    private String description;

    @Column(name = "VALOR")
    private Long value;

    @Column(name = "ATIVO")
    private boolean active;

    @Column(name = "VERSION")
    private Long version;
}