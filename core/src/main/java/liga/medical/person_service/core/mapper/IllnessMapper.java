package liga.medical.person_service.core.mapper;

import liga.medical.person_service.core.view.rest.controller.model.request.IllnessRequestForSave;
import liga.medical.person_service.core.view.rest.controller.model.request.IllnessRequestForUpdate;
import liga.medical.person_service.core.view.rest.controller.model.response.IllnessResponse;
import liga.medical.person_service.core.domain.Illness;
import liga.medical.person_service.core.dao.repository.entity.entity.IllnessEntity;
import liga.medical.person_service.core.service.dto.IllnessDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface IllnessMapper {

    @Mapping(target = "medicalCardDto", source = "medicalCardEntity")
    IllnessDto toDto(IllnessEntity illnessEntity);

    @Mapping(target = "medicalCardEntity", source = "medicalCardDto")
    IllnessEntity toEntity(IllnessDto illnessDto);

    @Mapping(target = "medicalCardResponse", source = "medicalCardDto")
    IllnessResponse toResponse(IllnessDto illnessDto);

    @Mapping(target = "id", expression = "java(null)")
    Illness toDomain(IllnessRequestForSave request);

    Illness toDomain(IllnessRequestForUpdate request);
}
