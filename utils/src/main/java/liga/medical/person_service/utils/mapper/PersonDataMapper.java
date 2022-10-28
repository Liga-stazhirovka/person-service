package liga.medical.person_service.utils.mapper;

import liga.medical.person_service.dao.entity.MedicalCardEntity;
import liga.medical.person_service.dao.entity.PersonDataEntity;
import liga.medical.person_service.dto.MedicalCardDto;
import liga.medical.person_service.dto.PersonDataDto;
import liga.medical.person_service.response.PersonDataResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface PersonDataMapper {
    PersonDataDto toDto(PersonDataEntity personDataEntity);

    PersonDataEntity toEntity(PersonDataDto personDataDto);

    PersonDataResponse toResponse(PersonDataDto personDataDto);
}
