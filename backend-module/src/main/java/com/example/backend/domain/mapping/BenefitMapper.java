package com.example.backend.domain.mapping;


import com.example.backend.domain.entity.BenefitEntity;
import com.example.backend.domain.model.BenefitDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BenefitMapper {
    BenefitEntity mapToEntity(BenefitDTO benefitDTO);
    BenefitDTO mapToDto(BenefitEntity entity);
}
