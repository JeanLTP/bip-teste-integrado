package com.example.backendforfrontend.infrastructure.client;

import com.example.backendforfrontend.domain.model.BenefitDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
