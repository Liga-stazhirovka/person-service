package liga.medical.person_service.core.mapper;

import liga.medical.person_service.core.controller.model.request.PersonDataRequestForSave;
import liga.medical.person_service.core.controller.model.request.PersonDataRequestForUpdate;
import liga.medical.person_service.core.domain.PersonData;
import liga.medical.person_service.core.repository.entity.entity.PersonDataEntity;
import liga.medical.person_service.core.controller.model.response.PersonDataResponse;
import liga.medical.person_service.core.service.dto.PersonDataDto;
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

    @Mapping(target = "medicalCardResponse", source = "medicalCardDto")
    @Mapping(target = "contactResponse", source = "contactDto")
    PersonDataResponse toResponse(PersonDataDto personDataDto);

    @Mapping(target = "id", expression = "java(null)")
    PersonData toDomain(PersonDataRequestForSave request);

    PersonData toDomain(PersonDataRequestForUpdate request);


}
