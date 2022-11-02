package liga.medical.person_service.utils.mapper;

import liga.medical.person_service.dao.entity.PersonDataEntity;
import liga.medical.person_service.dto.PersonDataDto;
import liga.medical.person_service.response.PersonDataResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PersonDataMapper {
    @Mapping(target = "medicalCardDto", source = "medicalCardEntity")
    @Mapping(target = "contactDto", source = "contactEntity")
    PersonDataDto toDto(PersonDataEntity personDataEntity);

    @Mapping(target = "contactEntity", source = "contactDto")
    @Mapping(target = "medicalCardEntity", source = "medicalCardDto")
    PersonDataEntity toEntity(PersonDataDto personDataDto);

    PersonDataResponse toResponse(PersonDataDto personDataDto);
}
