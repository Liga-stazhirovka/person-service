package liga.medical.person_service.core.mapper;

import liga.medical.person_service.core.controller.model.response.AddressResponse;
import liga.medical.person_service.core.domain.Address;
import liga.medical.person_service.core.repository.entity.entity.AddressEntity;
import liga.medical.person_service.core.service.dto.AddressDto;
import liga.medical.person_service.core.controller.model.request.AddressRequestForSave;
import liga.medical.person_service.core.controller.model.request.AddressRequestForUpdate;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressMapper {
    @Mapping(target = "contactDto", source = "contactEntity")
    AddressDto toDto(AddressEntity addressEntity);

    Address toDomain(AddressRequestForUpdate addressRequestForUpdate);

    @Mapping(target = "id", expression = "java(null)")
    Address toDomain(AddressRequestForSave addressRequestForSave);

    @Mapping(target = "contactEntity", source = "contactDto")
    AddressEntity toEntity(AddressDto addressDto);

    @Mapping(target = "contactResponse", source = "contactDto")
    AddressResponse toResponse(AddressDto dto);
}
