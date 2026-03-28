package com.example.backendforfrontend.infrastructure.client;

import com.example.backendforfrontend.domain.entity.BenefitEntity;
import com.example.backendforfrontend.domain.model.BenefitDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "benefitBackend", url = "${benefit.backend.url}")
public interface BenefitClient {

    @PostMapping("/benefits")
    Long createBenefit(@RequestBody BenefitDTO benefitEntity);

    @GetMapping("/benefits")
    List<BenefitDTO> getBenefits();

    @GetMapping("benefits/{id}")
    BenefitDTO findBenefitById(@PathVariable Long id);

    @PutMapping("/benefits/{id}")
    BenefitDTO updateBenefit(@PathVariable Long id, @RequestBody BenefitDTO benefitDTO);
}
