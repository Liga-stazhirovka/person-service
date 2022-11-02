package liga.medical.person_service.utils.mapper;

import liga.medical.person_service.dao.entity.UserEntity;
import liga.medical.person_service.dto.UserDto;
import liga.medical.person_service.dto.UserLogin;
import liga.medical.person_service.dto.UserRegistration;
import liga.medical.person_service.response.UserResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UserMapper {

    UserDto toDto(UserEntity userEntity);

    @Mapping(target = "id", expression = "java(null)")
    UserDto toDto(UserRegistration userRegistration);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "lastName", expression = "java(null)")
    @Mapping(target = "firstName", expression = "java(null)")
    @Mapping(target = "roles", expression = "java(null)")
    UserDto toDto(UserLogin userLogin);

    UserEntity toEntity(UserDto userDto);

    UserResponse toResponse(UserDto dto);


}
