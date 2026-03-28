package com.example.backendforfrontend.domain.service.impl;

import com.example.backendforfrontend.application.facade.BenefitFacade;
import com.example.backendforfrontend.domain.model.BenefitDTO;
import com.example.backendforfrontend.domain.service.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BenefitServiceImpl implements BenefitService {

    @Autowired
    BenefitFacade benefitFacade;

    @Override
    public List<BenefitDTO> findBenefits() {
        return benefitFacade.getBenefits();
    }

    @Override
    public List<String> list() {
        return benefitFacade.list();
    }
}
