package com.example.backendforfrontend.domain.resource.impl;

import com.example.backendforfrontend.domain.model.BenefitDTO;
import com.example.backendforfrontend.domain.resource.BenefitResource;
import com.example.backendforfrontend.domain.service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BenefitResourceImpl implements BenefitResource {

    @Autowired
    private BenefitService benefitService;


    @Override
    public ResponseEntity<Map<String, Long>> createBenefit(BenefitDTO benefitDTO) {
        return benefitService.createBenefit(benefitDTO);
    }

    @Override
    public List<BenefitDTO> findBenefits() {
        return benefitService.findBenefits();
    }

    @Override
    public ResponseEntity<BenefitDTO> findBenefitById(Long id) {
        return benefitService.findBenefitById(id);
    }

    @Override
    public BenefitDTO updateBenefit(Long id, BenefitDTO benefitDTO) {
        return benefitService.updateBenefit(id, benefitDTO);
    }
}
