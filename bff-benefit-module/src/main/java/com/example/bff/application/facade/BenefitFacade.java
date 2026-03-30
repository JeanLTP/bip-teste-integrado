package com.example.bff.application.facade;

import com.example.bff.domain.model.BenefitDTO;
import com.example.bff.domain.model.TransferRequestDTO;
import com.example.bff.infrastructure.client.BenefitClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BenefitFacade {

    private final BenefitClient client;

    public ResponseEntity<Map<String, Long>> createBenefit(BenefitDTO benefitDTO) { return client.createBenefit(benefitDTO); }

    public List<BenefitDTO> getBenefits() {
        return client.getBenefits();
    }

    public BenefitDTO updateBenefit(Long id, BenefitDTO benefitDTO) {
        return client.updateBenefit(id, benefitDTO);
    }

    public BenefitDTO findBenefitById(Long id) { return client.findBenefitById(id);}

    public void transfer(TransferRequestDTO transferRequestDTO) { client.transfer(transferRequestDTO); }
}

