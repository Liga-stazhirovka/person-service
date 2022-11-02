package liga.medical.person_service.utils.mapper;

import liga.medical.person_service.dao.entity.IllnessEntity;
import liga.medical.person_service.dto.IllnessDto;
import liga.medical.person_service.response.IllnessResponse;
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

    IllnessResponse toResponse(IllnessDto illnessDto);
}
