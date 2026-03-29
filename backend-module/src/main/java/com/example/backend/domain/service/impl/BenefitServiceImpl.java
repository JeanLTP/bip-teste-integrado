package com.example.backend.domain.service.impl;

import com.example.backend.domain.mapping.BenefitMapper;
import com.example.backend.domain.model.BenefitDTO;
import com.example.backend.domain.service.BenefitService;
import com.example.backend.infrastructure.repository.BenefitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BenefitServiceImpl implements BenefitService {

    @Autowired
    BenefitRepository benefitRepository;

    @Autowired
    BenefitMapper benefitMapper;

    @Override
    public Long createBenefit(BenefitDTO benefitDTO) {
        var benefitEntity = benefitMapper.mapToEntity(benefitDTO);

        benefitRepository.save(benefitEntity);

        return benefitEntity.getId();
    }

    @Override
    public List<BenefitDTO> findBenefits() {
        return benefitRepository.findAll()
                .stream()
                .map(benefitMapper::mapToDto)
                .toList();
    }

    @Override
    public BenefitDTO findBenefitById(Long id) {
        return benefitRepository.findById(id)
                .map(benefitMapper::mapToDto)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Benefício não encontrado"
                ));
    }

    @Override
    public BenefitDTO updateBenefit(Long id, BenefitDTO benefitDTO) {
        var entity = benefitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Benefício não encontrado"));

        entity.setName(benefitDTO.getName());
        entity.setDescription(benefitDTO.getDescription());
        entity.setValue(benefitDTO.getValue());
        entity.setActive(benefitDTO.isActive());

        var updated = benefitRepository.save(entity);
        return benefitMapper.mapToDto(updated);

    }
}
