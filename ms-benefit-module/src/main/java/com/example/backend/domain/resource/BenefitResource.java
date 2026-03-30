package com.example.backend.domain.resource;

import com.example.backend.domain.model.BenefitDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Tag(name= "Benefícios", description = "Responsável por interações relacionadas a benefícios.")
@RequestMapping("/benefits")
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
    BenefitDTO findBenefitById(@PathVariable Long id);

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualiza um beneficio existente.",
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
    void transfer(
            @RequestBody @NotBlank Long fromId,
            @RequestBody @NotBlank Long toId,
            @RequestBody @NotBlank BigDecimal amount
    );
}
