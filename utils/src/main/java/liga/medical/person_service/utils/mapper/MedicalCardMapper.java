package liga.medical.person_service.utils.mapper;

import liga.medical.person_service.dao.entity.MedicalCardEntity;
import liga.medical.person_service.dto.MedicalCardDto;
import liga.medical.person_service.response.MedicalCardResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface MedicalCardMapper {

    MedicalCardDto toDto(MedicalCardEntity medicalCardEntity);

    MedicalCardEntity toEntity(MedicalCardDto medicalCardDto);

    MedicalCardResponse toResponse(MedicalCardDto medicalCardDto);
}
