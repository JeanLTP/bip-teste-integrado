package com.example.backendforfrontend.domain.resource;

import com.example.backendforfrontend.domain.model.BenefitDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/benefits")
@Tag(name= "Benefícios", description = "Responsável por interações relacionadas a benefícios.")
public interface BenefitResource {

    @PostMapping("")
    @Operation(
            summary = "Efetua a criação de um novo benefício.",
            description = "Retorna o ID do beneficio criado."
    )
    Long createBenefit(@RequestBody BenefitDTO benefitDTO);

    @GetMapping("")
    @Operation(
            summary = "Busca de todos os benefícios cadastrados.",
            description = "Retorna todos os benefícios."
    )
    List<BenefitDTO> findBenefits();

    @GetMapping("/{id}")
    @Operation(
            summary = "Busca benefício por id.",
            description = "Retorna benefício consultado."
    )
    BenefitDTO findBenefitById(@PathVariable Long id);

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualiza um benefício existente.",
            description = "Retorna o objeto do beneficio atualizado."
    )
    BenefitDTO updateBenefit(
            @PathVariable Long id,
            @RequestBody BenefitDTO benefitDTO
    );
}
