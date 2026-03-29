package com.example.backend.domain.service;

import com.example.backend.domain.entity.BenefitEntity;
import com.example.backend.domain.model.BenefitDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public interface BenefitService {
    Long createBenefit(BenefitDTO benefitDTO);
    List<BenefitDTO> findBenefits();
    BenefitDTO findBenefitById(Long id);
    BenefitDTO updateBenefit(Long id, BenefitDTO benefitDTO);
    void transfer(Long fromId, Long toId, BigDecimal amount);
}
