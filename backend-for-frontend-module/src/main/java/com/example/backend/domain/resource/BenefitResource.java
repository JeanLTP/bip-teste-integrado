package com.example.backend.domain.resource;

import com.example.backend.domain.model.Benefit;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/v1/benefits")
@Tag(name= "Benefícios", description = "Responsável por interações relacionadas a benefícios.")
public interface BenefitResource {

    @GetMapping
    @Operation(
            summary = "Busca de todos os benefícios cadastrados.",
            description = "Retorna todos os benefícios."
    )
    public List<Benefit> findBenefits();

    @GetMapping("/test")
    @Operation(
            summary = "Busca de todos os benefícios cadastrados.",
            description = "Retorna todos os benefícios."
    )
    public List<String> list();
}
