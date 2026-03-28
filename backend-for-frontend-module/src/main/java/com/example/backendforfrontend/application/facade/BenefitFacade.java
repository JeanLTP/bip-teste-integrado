package com.example.backendforfrontend.application.facade;

import com.example.backendforfrontend.domain.entity.BenefitEntity;
import com.example.backendforfrontend.domain.model.BenefitDTO;
import com.example.backendforfrontend.infrastructure.client.BenefitClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitFacade {

    private final BenefitClient client;

    public Long createBenefit(BenefitDTO benefitDTO) {return client.createBenefit(benefitDTO);}

    public List<BenefitDTO> getBenefits() {
        return client.getBenefits();
    }

    public BenefitDTO updateBenefit(Long id, BenefitDTO benefitDTO) {
        return client.updateBenefit(id, benefitDTO);
    }

    public BenefitDTO findBenefitById(Long id) { return client.findBenefitById(id);}
}

