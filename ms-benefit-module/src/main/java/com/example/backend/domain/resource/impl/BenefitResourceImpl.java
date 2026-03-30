package com.example.backend.domain.resource.impl;

import com.example.backend.domain.model.BenefitDTO;
import com.example.backend.domain.model.TransferRequestDTO;
import com.example.backend.domain.resource.BenefitResource;
import com.example.backend.domain.service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class BenefitResourceImpl implements BenefitResource {

    @Autowired
    private BenefitService benefitService;


    @Override
    public ResponseEntity<Map<String, Long>> createBenefit(BenefitDTO benefitDTO) {
        var id = benefitService.createBenefit(benefitDTO);
        Map<String, Long> response = Collections.singletonMap("id", id);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public List<BenefitDTO> findBenefits() {
        return benefitService.findBenefits();
    }

    @Override
    public BenefitDTO findBenefitById(Long id) { return benefitService.findBenefitById(id); }

    @Override
    public BenefitDTO updateBenefit(Long id, BenefitDTO benefitDTO) {
        return benefitService.updateBenefit(id, benefitDTO);
    }

    @Override
    public void transfer(TransferRequestDTO transferRequestDTO) { benefitService.transfer(transferRequestDTO); }
}
