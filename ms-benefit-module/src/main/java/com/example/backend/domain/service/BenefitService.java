package com.example.backend.domain.service;

import com.example.backend.domain.model.BenefitDTO;
import com.example.backend.domain.model.TransferRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BenefitService {
    Long createBenefit(BenefitDTO benefitDTO);
    List<BenefitDTO> findBenefits();
    BenefitDTO findBenefitById(Long id);
    BenefitDTO updateBenefit(Long id, BenefitDTO benefitDTO);
    void transfer(TransferRequestDTO transferRequestDTO);
}
