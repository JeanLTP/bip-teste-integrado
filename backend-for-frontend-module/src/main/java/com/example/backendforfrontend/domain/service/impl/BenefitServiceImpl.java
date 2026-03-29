package com.example.backendforfrontend.domain.service.impl;

import com.example.backendforfrontend.application.facade.BenefitFacade;
import com.example.backendforfrontend.domain.model.BenefitDTO;
import com.example.backendforfrontend.domain.service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class BenefitServiceImpl implements BenefitService {

    @Autowired
    BenefitFacade benefitFacade;

    @Override
    public ResponseEntity<Map<String, Long>> createBenefit(BenefitDTO benefitDTO) {
        return benefitFacade.createBenefit(benefitDTO);
    }

    @Override
    public BenefitDTO updateBenefit(Long id, BenefitDTO benefitDTO) {
        return benefitFacade.updateBenefit(id, benefitDTO);
    }

    @Override
    public ResponseEntity<BenefitDTO> findBenefitById(Long id) {
        var dto = benefitFacade.findBenefitById(id);
        return ResponseEntity.ok(dto);
    }

    @Override
    public List<BenefitDTO> findBenefits() {
        return benefitFacade.getBenefits();
    }
}
