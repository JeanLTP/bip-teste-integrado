package com.example.backend.domain.service;

import com.example.backend.domain.entity.BenefitEntity;
import com.example.backend.domain.model.BenefitDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BenefitService {
    Long createBenefit(BenefitDTO benefitDTO);
    List<BenefitDTO> findBenefits();
    BenefitDTO findBenefitById(Long id);
    BenefitDTO updateBenefit(Long id, BenefitDTO benefitDTO);
}
