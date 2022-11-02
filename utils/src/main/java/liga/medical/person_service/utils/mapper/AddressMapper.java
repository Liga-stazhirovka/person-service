package liga.medical.person_service.utils.mapper;

import liga.medical.person_service.dao.entity.AddressEntity;
import liga.medical.person_service.dto.AddressDto;
import liga.medical.person_service.response.AddressResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AddressMapper {
    @Mapping(target = "contactDto", source = "contactEntity")
    AddressDto toDto(AddressEntity addressEntity);
    @Mapping(target = "contactEntity", source = "contactDto")
    AddressEntity toEntity(AddressDto addressDto);


    AddressResponse toResponse(AddressDto dto);

}
