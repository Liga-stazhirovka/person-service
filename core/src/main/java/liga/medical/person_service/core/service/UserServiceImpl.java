package liga.medical.person_service.core.service;

import liga.medical.person_service.api.repository.UserRepository;
import liga.medical.person_service.api.service.UserService;
import liga.medical.person_service.api.service.model.Role;
import liga.medical.person_service.api.service.model.User;
import liga.medical.person_service.core.exceptions.AuthorizationException;
import liga.medical.person_service.core.exceptions.IllegalArgumentException;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.dao.entity.UserEntity;
import liga.medical.person_service.dto.UserDto;
import liga.medical.person_service.dto.UserLogin;
import liga.medical.person_service.dto.UserRegistration;
import liga.medical.person_service.response.UserResponse;
import liga.medical.person_service.utils.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;
//    private final PasswordEncoder encoder;

    public UserDto login(UserLogin user) {
//        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(user.getEmail());
//        if (optionalUserEntity.isEmpty() ||
//                !(optionalUserEntity.get().getPassword().equals(encoder.encode(user.getPassword()))))
//            throw new AuthorizationException("Email or password wrong! Email: " + user.getEmail() +
//                    " , Password: " + user.getPassword());
//        return mapper.toDto(optionalUserEntity.get());
        return null;
    }

    public UserDto signUp(UserRegistration user) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(user.getEmail());
        if (optionalUserEntity.isPresent())
            throw new AuthorizationException("Registration error! Email already exist: " + user.getEmail());
        return save(mapper.toDto(user));
    }

    @Override
    public UserDto findByFirstName(String name) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByFirstName(name);
        if (optionalUserEntity.isEmpty())
            throw new NotFoundException("User by first name not found: " + name);
        return mapper.toDto(optionalUserEntity.get());
    }

    @Override
    public UserDto getById(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isEmpty())
            throw new NotFoundException("User by id not found: " + id);
        return mapper.toDto(optionalUserEntity.get());
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto userDto) {
        Optional<UserEntity> optionalUserEntityById = userRepository.findById(userDto.getId());
        Optional<UserEntity> optionalUserEntityByEmail = userRepository.findByEmail(userDto.getEmail());
        if (optionalUserEntityById.isPresent())
            throw new IllegalArgumentException("User save error! User already exist with ID: " + userDto.getId());
        if (optionalUserEntityByEmail.isPresent())
            throw new IllegalArgumentException("User save error! User already exist with email: " + userDto.getEmail());
        userRepository.save(mapper.toEntity(userDto));
        return userDto;
    }

    @Override
    public UserDto update(UserDto dto) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(dto.getId());
        if (optionalUserEntity.isEmpty())
            throw new NotFoundException("Update error! User by id not found: " + dto.getId());
        userRepository.save(optionalUserEntity.get());
        return dto;
    }

    @Override
    public Long delete(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isEmpty())
            throw new NotFoundException("Delete error! User by id not found: " + id);
        userRepository.delete(optionalUserEntity.get());
        return id;
    }

    @Override
    public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
        var optionalUserEntity = userRepository.findByFirstName(firstName);
        if (optionalUserEntity.isPresent()) {
            return User.builder()
                    .id(optionalUserEntity.get().getId())
                    .password(optionalUserEntity.get().getPassword())
                    .firstName(optionalUserEntity.get().getFirstName())
                    .secondName(optionalUserEntity.get().getLastName())
                    .email(optionalUserEntity.get().getEmail())
                    .roles(optionalUserEntity.get().getRoles()
                            .stream()
                            .map(it ->  Role.valueOf(it.getRoleName()))
                            .collect(Collectors.toSet()))
                    .build();
        } else {
            throw new UsernameNotFoundException(String.format("User %s not found", firstName));
        }
    }
}
