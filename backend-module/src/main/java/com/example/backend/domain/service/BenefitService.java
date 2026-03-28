package com.example.backend.domain.service;

import com.example.backend.domain.model.BenefitDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BenefitService {
    List<BenefitDTO> findBenefits();

    List<String> list();
}
