package com.example.backendforfrontend.domain.service;

import com.example.backendforfrontend.domain.model.BenefitDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BenefitService {
    List<BenefitDTO> findBenefits();

    List<String> list();
}
