package com.example.bff.domain.resource;

import com.example.bff.domain.model.BenefitDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/benefits")
@Tag(name= "Benefícios", description = "Responsável por interações relacionadas a benefícios.")
public interface BenefitResource {

    @PostMapping("")
    @Operation(
            summary = "Efetua a criação de um novo benefício.",
            description = "Retorna o ID do beneficio criado."
    )
    ResponseEntity<Map<String, Long>> createBenefit(@RequestBody BenefitDTO benefitDTO);

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
    ResponseEntity<BenefitDTO> findBenefitById(@PathVariable Long id);

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualiza um benefício existente.",
            description = "Retorna o objeto do beneficio atualizado."
    )
    BenefitDTO updateBenefit(
            @PathVariable Long id,
            @RequestBody BenefitDTO benefitDTO
    );

    @PostMapping("/transfer")
    @Operation(
            summary = "Atualiza o valor de um benefício",
            description = "Deve fazer a transferência e atualizar o valor de ambos os benefícios"
    )
    ResponseEntity<Map<String, String>> transfer(
            @RequestBody @NotBlank Long fromId,
            @RequestBody @NotBlank Long toId,
            @RequestBody @NotBlank BigDecimal amount
    );
}
