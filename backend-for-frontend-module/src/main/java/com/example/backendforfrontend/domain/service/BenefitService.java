package com.example.backendforfrontend.domain.service;

import com.example.backendforfrontend.domain.model.BenefitDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BenefitService {
    Long createBenefit(BenefitDTO benefitDTO);
    List<BenefitDTO> findBenefits();
    BenefitDTO findBenefitById(Long id);
    BenefitDTO updateBenefit(Long id, BenefitDTO benefitDTO);
}
