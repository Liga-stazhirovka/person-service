package liga.medical.person_service.core.mapper;

import liga.medical.person_service.core.controller.model.request.ContactRequestForSave;
import liga.medical.person_service.core.controller.model.request.ContactRequestForUpdate;
import liga.medical.person_service.core.domain.Contact;
import liga.medical.person_service.core.repository.entity.entity.ContactEntity;
import liga.medical.person_service.core.controller.model.response.ContactResponse;
import liga.medical.person_service.core.service.dto.ContactDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ContactMapper {
    ContactDto toDto(ContactEntity contactEntity);

    ContactEntity toEntity(ContactDto contactDto);

    Contact toDomain(ContactRequestForUpdate request);

    @Mapping(target = "id", expression = "java(null)")
    Contact toDomain(ContactRequestForSave request);

    ContactResponse toResponse(ContactDto contactDto);
}
