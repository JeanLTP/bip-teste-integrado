package com.example.backendforfrontend.domain.resource.impl;

import com.example.backendforfrontend.domain.model.BenefitDTO;
import com.example.backendforfrontend.domain.resource.BenefitResource;
import com.example.backendforfrontend.domain.service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BenefitResourceImpl implements BenefitResource {

    @Autowired
    private BenefitService benefitService;


    @Override
    public List<BenefitDTO> findBenefits() {
        return benefitService.findBenefits();
    }

    @Override
    public List<String> list() {
        return  benefitService.list();
    }
}
