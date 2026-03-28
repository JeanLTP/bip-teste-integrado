package com.example.backendforfrontend.infrastructure.client;

import com.example.backendforfrontend.domain.model.BenefitDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "benefitBackend", url = "${benefit.backend.url}")
public interface BenefitClient {
    @GetMapping("/benefits")
    List<BenefitDTO> getBenefits();

    @GetMapping("/test")
    List<String> list();
}
