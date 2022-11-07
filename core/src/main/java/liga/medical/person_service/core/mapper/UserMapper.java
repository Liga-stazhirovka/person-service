package liga.medical.person_service.core.mapper;

import liga.medical.person_service.core.controller.model.request.UserRequestForSave;
import liga.medical.person_service.core.controller.model.request.UserRequestForUpdate;
import liga.medical.person_service.core.controller.model.response.UserResponse;
import liga.medical.person_service.core.domain.User;
import liga.medical.person_service.core.repository.entity.entity.UserEntity;
import liga.medical.person_service.core.service.dto.UserDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {RoleMapper.class})
public interface UserMapper {

    UserDto toDto(UserEntity userEntity);

    UserDto toDto(User user);

    UserEntity toEntity(UserDto dto);

    UserResponse toResponse(UserDto dto);

    @Mapping(target = "id", expression = "java(null)")
    User toDomain(UserRequestForSave request);

    User toDomain(UserRequestForUpdate request);
}
