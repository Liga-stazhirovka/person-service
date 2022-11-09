package liga.medical.person_service.core.mapper;


import liga.medical.person_service.core.view.rest.controller.model.request.MedicalCardRequestForSave;
import liga.medical.person_service.core.view.rest.controller.model.request.MedicalCardRequestForUpdate;
import liga.medical.person_service.core.domain.MedicalCard;
import liga.medical.person_service.core.dao.repository.entity.entity.MedicalCardEntity;
import liga.medical.person_service.core.view.rest.controller.model.response.MedicalCardResponse;
import liga.medical.person_service.core.service.dto.MedicalCardDto;

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

    @Mapping(target = "id", expression = "java(null)")
    MedicalCard toDomain(MedicalCardRequestForSave request);

    MedicalCard toDomain(MedicalCardRequestForUpdate request);
}
