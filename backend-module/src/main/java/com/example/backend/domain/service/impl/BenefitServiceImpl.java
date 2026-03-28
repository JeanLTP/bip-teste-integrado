package com.example.backend.domain.service.impl;

import com.example.backend.domain.model.BenefitDTO;
import com.example.backend.domain.service.BenefitService;
import com.example.backend.infrastructure.repository.BenefitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BenefitServiceImpl implements BenefitService {

    @Autowired
    BenefitRepository benefitRepository;

    @Override
    public List<BenefitDTO> findBenefits() {
        return List.of(
                new BenefitDTO(1L, "Vale Alimentação", "Benefício alimentação", 500L, true, 1L),
                new BenefitDTO(2L, "Vale Transporte", "Benefício transporte", 300L, true, 1L)
        );
        // TODO chamar repository

    }

    @Override
    public List<String> list() {
        return Arrays.asList("Beneficio A", "Beneficio B");
        // TODO chamar repository
    }
}
