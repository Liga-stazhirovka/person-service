package liga.medical.person_service.api.service;

import liga.medical.person_service.dto.UserDto;
import liga.medical.person_service.dto.UserLogin;
import liga.medical.person_service.dto.UserRegistration;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDto findByFirstName(String name);

    UserDto login(UserLogin user);

    UserDto signUp(UserRegistration user);

    UserDto getById(Long id);

    List<UserDto> getAll();

    UserDto save(UserDto dto);

    UserDto update(UserDto dto);

    Long delete(Long id);
}

