package com.example.bff.domain.service;

import com.example.bff.domain.model.BenefitDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BenefitService {
    ResponseEntity<Map<String, Long>> createBenefit(BenefitDTO benefitDTO);
    List<BenefitDTO> findBenefits();
    ResponseEntity<BenefitDTO> findBenefitById(Long id);
    BenefitDTO updateBenefit(Long id, BenefitDTO benefitDTO);
}
