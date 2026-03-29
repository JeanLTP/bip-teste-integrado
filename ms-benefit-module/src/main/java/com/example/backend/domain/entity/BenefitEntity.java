package com.example.backend.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Long value;

    @Column(name = "ATIVO")
    private boolean active;

    @Column(name = "VERSION")
    @Version
    private Long version;
}