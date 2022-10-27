package liga.medical.person_service.utils.mapper;

import liga.medical.person_service.dao.entity.ContactEntity;
import liga.medical.person_service.dto.ContactDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ContactMapper {
    ContactDto toDto(ContactEntity contactEntity);

    ContactEntity toEntity(ContactDto contactDto);
}
