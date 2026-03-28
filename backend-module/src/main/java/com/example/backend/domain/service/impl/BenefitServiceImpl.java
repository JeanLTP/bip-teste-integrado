package com.example.backend.domain.service.impl;

import com.example.backend.domain.entity.BenefitEntity;
import com.example.backend.domain.mapping.BenefitMapper;
import com.example.backend.domain.model.BenefitDTO;
import com.example.backend.domain.service.BenefitService;
import com.example.backend.infrastructure.repository.BenefitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        var entityList = benefitRepository.findAll();
        return entityList.stream()
                .map(entity -> benefitMapper.mapToDto(entity))
                .toList();
    }

    @Override
    public BenefitDTO findBenefitById(Long id) {
        var existEntity = benefitRepository.findById(id);
        if (existEntity.isEmpty()) {
            throw new RuntimeException("Benefício que foi solicitado a alteração não encontrado na base.");
        }

        return benefitMapper.mapToDto(existEntity.get());
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
