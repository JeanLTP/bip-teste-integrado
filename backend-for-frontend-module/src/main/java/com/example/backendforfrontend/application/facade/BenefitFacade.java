package com.example.backendforfrontend.application.facade;

import com.example.backendforfrontend.domain.model.BenefitDTO;
import com.example.backendforfrontend.infrastructure.client.BenefitClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitFacade {

    private final BenefitClient client;

    public List<BenefitDTO> getBenefits() {
        return client.getBenefits();
    }

    public List<String> list() {
        return client.list();
    }
}

