package liga.medical.person_service.core.service;

import liga.medical.person_service.core.domain.Role;
import liga.medical.person_service.core.exceptions.IllegalArgumentException;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.core.mapper.RoleMapper;
import liga.medical.person_service.core.repository.RoleRepository;
import liga.medical.person_service.core.repository.entity.entity.AddressEntity;
import liga.medical.person_service.core.repository.entity.entity.RoleEntity;
import liga.medical.person_service.core.service.api.RoleService;
import liga.medical.person_service.core.service.dto.RoleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public RoleDto getById(Long id) {
        Optional<RoleEntity> optionalRoleEntity = repository.findById(id);
        if (optionalRoleEntity.isEmpty())
            throw new NotFoundException("Role by Id not fount, Id: " + id);
        return mapper.toDto(optionalRoleEntity.get());
    }

    @Override
    public List<RoleDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoleDto save(Role role) {
        Optional<RoleEntity> optionalRoleEntity = repository.findByName(role.getName());
        if (optionalRoleEntity.isPresent())
            throw new IllegalArgumentException("Role save error! Role already exist, role: " + role.getName());
        return mapper.toDto(repository.save(mapper.toEntity(buildRoleDtoForSave(role))));
    }

    @Override
    public RoleDto update(Role role) {
        Optional<RoleEntity> optionalRoleEntity = repository.findById(role.getId());
        if (optionalRoleEntity.isEmpty())
            throw new NotFoundException("Role update error! Role by id not found, id: " + role.getId());
        return mapper.toDto(repository.save(mapper.toEntity(buildRoleDtoForUpdate(role))));
    }

    @Override
    public Long delete(Long id) {
        Optional<RoleEntity> optionalRoleEntity = repository.findById(id);
        if (optionalRoleEntity.isEmpty())
            throw new NotFoundException("Role delete error! Role by Id not fount, Id: " + id);
        repository.delete(optionalRoleEntity.get());
        return id;
    }

    private RoleDto buildRoleDtoForSave(Role role) {
        return RoleDto.builder()
                .name(role.getName())
                .build();
    }

    private RoleDto buildRoleDtoForUpdate(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }
}
