package com.example.backend.domain.resource.impl;

import com.example.backend.domain.model.Benefit;
import com.example.backend.domain.resource.BenefitResource;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class BenefitResourceImpl implements BenefitResource {

    @Override
    public List<Benefit> findBenefits() {
        return List.of(
                new Benefit(1L, "Vale Alimentação", "Benefício alimentação", 500L, true, 1L),
                new Benefit(2L, "Vale Transporte", "Benefício transporte", 300L, true, 1L)
        );
    }

    @Override
    public List<String> list() {
        return Arrays.asList("Beneficio A", "Beneficio B");
    }
}
