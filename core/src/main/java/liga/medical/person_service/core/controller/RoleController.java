package liga.medical.person_service.core.controller;

import liga.medical.person_service.core.controller.model.request.RoleRequestForSave;
import liga.medical.person_service.core.controller.model.request.RoleRequestForUpdate;
import liga.medical.person_service.core.controller.model.response.RoleResponse;
import liga.medical.person_service.core.mapper.RoleMapper;
import liga.medical.person_service.core.service.api.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final RoleService service;
    private final RoleMapper mapper;

    @GetMapping("/{id}")
    public RoleResponse findById(@PathVariable @NotNull Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @GetMapping("/all")
    public List<RoleResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public RoleResponse add(@RequestBody RoleRequestForSave request) {
        return mapper.toResponse(service.save(mapper.toDomain(request)));
    }

    @PutMapping("/update")
    public RoleResponse update(@RequestBody RoleRequestForUpdate request) {
        return mapper.toResponse(service.update(mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        return service.delete(id);
    }
}
