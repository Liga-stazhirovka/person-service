package liga.medical.person_service.core.service.api;

import liga.medical.person_service.core.domain.User;
import liga.medical.person_service.core.service.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    UserDto findByFirstName(String name);

    UserDto findByEmail(String email);

    UserDto getById(Long id);

    List<UserDto> getAll();

    UserDto save(User userEntity);

    UserDto update(User userEntity);

    Long delete(Long id);
}

