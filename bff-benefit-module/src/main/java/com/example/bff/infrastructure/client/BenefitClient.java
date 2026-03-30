package com.example.bff.infrastructure.client;

import com.example.bff.domain.model.BenefitDTO;
import jakarta.validation.constraints.NotBlank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@FeignClient(name = "benefitBackend", url = "${benefit.backend.url}")
public interface BenefitClient {

    @PostMapping("/benefits")
    ResponseEntity<Map<String, Long>> createBenefit(@RequestBody BenefitDTO benefitEntity);

    @GetMapping("/benefits")
    List<BenefitDTO> getBenefits();

    @GetMapping("benefits/{id}")
    BenefitDTO findBenefitById(@PathVariable Long id);

    @PutMapping("/benefits/{id}")
    BenefitDTO updateBenefit(@PathVariable Long id, @RequestBody BenefitDTO benefitDTO);

    @PostMapping("/benefits/transfer")
    void transfer(@RequestBody @NotBlank Long fromId, @RequestBody @NotBlank Long toId, @RequestBody @NotBlank BigDecimal amount);
}
