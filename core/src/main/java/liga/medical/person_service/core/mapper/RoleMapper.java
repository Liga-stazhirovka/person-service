package liga.medical.person_service.core.mapper;

import liga.medical.person_service.core.controller.model.request.RoleRequestForSave;
import liga.medical.person_service.core.controller.model.request.RoleRequestForUpdate;
import liga.medical.person_service.core.controller.model.response.RoleResponse;
import liga.medical.person_service.core.domain.Role;
import liga.medical.person_service.core.repository.entity.entity.RoleEntity;
import liga.medical.person_service.core.service.dto.RoleDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface RoleMapper {
    @Mapping(target = "users", expression = "java(null)")
    RoleEntity toEntity(RoleDto roleDto);

    @Mapping(target = "users", expression = "java(null)")
    RoleEntity toEntity(Role role);

    RoleDto toDto(RoleEntity roleEntity);

    RoleDto toDto(Role role);

    RoleResponse toResponse(RoleDto request);

    @Mapping(target = "id", expression = "java(null)")
    Role toDomain(RoleRequestForSave request);

    Role toDomain(RoleRequestForUpdate request);
}
