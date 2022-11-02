package liga.medical.person_service.utils.mapper;

import liga.medical.person_service.dao.entity.RoleEntity;
import liga.medical.person_service.dto.RoleDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RoleMapper {
    RoleEntity toEntity(RoleDto roleDto);

    RoleDto toDto(RoleEntity roleEntity);

}
