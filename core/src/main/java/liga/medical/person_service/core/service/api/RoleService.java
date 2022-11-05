package liga.medical.person_service.core.service.api;

import liga.medical.person_service.core.domain.Role;
import liga.medical.person_service.core.service.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto getById(Long id);

    List<RoleDto> getAll();

    RoleDto save(Role role);

    RoleDto update(Role role);

    Long delete(Long id);
}
