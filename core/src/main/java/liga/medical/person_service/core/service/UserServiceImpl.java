package liga.medical.person_service.core.service;

import liga.medical.person_service.core.domain.User;
import liga.medical.person_service.core.exceptions.IllegalArgumentException;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.core.mapper.RoleMapper;
import liga.medical.person_service.core.mapper.UserMapper;
import liga.medical.person_service.core.repository.RoleRepository;
import liga.medical.person_service.core.repository.UserRepository;
import liga.medical.person_service.core.repository.entity.entity.RoleEntity;
import liga.medical.person_service.core.repository.entity.entity.UserEntity;
import liga.medical.person_service.core.service.api.UserService;
import liga.medical.person_service.core.service.dto.RoleDto;
import liga.medical.person_service.core.service.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) {
        UserDto user = findByEmail(email);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getName())));

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), grantedAuthorities);
    }

    @Override
    public UserDto findByFirstName(String name) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByFirstName(name);
        if (optionalUserEntity.isEmpty())
            throw new NotFoundException("User by first name not fount, First Name: " + name);
        return userMapper.toDto(optionalUserEntity.get());
    }

    @Override
    public UserDto findByEmail(String email) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(email);
        if (optionalUserEntity.isEmpty())
            throw new NotFoundException("User by email not fount, Email: " + email);
        return userMapper.toDto(optionalUserEntity.get());
    }

    @Override
    public UserDto getById(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isEmpty())
            throw new NotFoundException("User by Id not fount, Id: " + id);
        return userMapper.toDto(optionalUserEntity.get());
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Long delete(Long id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(id);
        if (optionalUserEntity.isEmpty())
            throw new NotFoundException("User delete error! User by Id not fount, Id: " + id);
        userRepository.delete(optionalUserEntity.get());
        return id;
    }

    @Override
    public UserDto save(User user) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByEmail(user.getEmail());
        if (optionalUserEntity.isPresent())
            throw new IllegalArgumentException("User save error! User already exist by email: " + user.getEmail());

        return userMapper.toDto(userRepository.save(userMapper.toEntity(findRolesAndBuildUserDtoForSave(user))));
    }

    @Override
    public UserDto update(User user) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(findRolesAndBuildUserDtoForUpdate(user))));
    }

    private UserDto findRolesAndBuildUserDtoForSave(User user) {
        if (!isContainsAllRolesByUser(user))
            throw new IllegalArgumentException("Save user error! User roles not found, roles: " + user.getRoles());

        Set<RoleDto> userRolesDto = user.getRoles().stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toSet());
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(encoder.encode(user.getPassword()))
                .roles(userRolesDto)
                .build();
    }

    private UserDto findRolesAndBuildUserDtoForUpdate(User user) {
        if (!isContainsAllRolesByUser(user))
            throw new IllegalArgumentException("Save user error! User roles not found, roles: " + user.getRoles());

        Set<RoleDto> userRolesDto = user.getRoles().stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toSet());
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(encoder.encode(user.getPassword()))
                .roles(userRolesDto)
                .build();
    }

    private boolean isContainsAllRolesByUser(User user) {
        List<RoleEntity> allRolesEntity = roleRepository.findAll();
        List<RoleEntity> userRolesEntity = user.getRoles().stream()
                .map(roleMapper::toEntity)
                .collect(Collectors.toList());
        return allRolesEntity.containsAll(userRolesEntity);
    }
}
