package com.example.backend.domain.resource;

import com.example.backend.domain.model.BenefitDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Tag(name= "Benefícios", description = "Responsável por interações relacionadas a benefícios.")
public interface BenefitResource {

    @GetMapping("/benefits")
    @Operation(
            summary = "Busca de todos os benefícios cadastrados.",
            description = "Retorna todos os benefícios."
    )
    public List<BenefitDTO> findBenefits();

    @GetMapping("/test")
    @Operation(
            summary = "Busca de todos os benefícios cadastrados.",
            description = "Retorna todos os benefícios."
    )
    public List<String> list();
}
