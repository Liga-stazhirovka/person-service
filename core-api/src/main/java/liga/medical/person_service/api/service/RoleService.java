package liga.medical.person_service.api.service;

import liga.medical.person_service.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto getById(Long id);

    List<RoleDto> getAll();

    RoleDto save(RoleDto dto);

    RoleDto update(RoleDto dto);

    Long delete(Long id);
}
