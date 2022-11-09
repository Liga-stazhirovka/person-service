package liga.medical.person_service.core.view.rest.controller;

import liga.medical.person_service.core.view.rest.controller.model.request.RoleRequestForSave;
import liga.medical.person_service.core.view.rest.controller.model.request.RoleRequestForUpdate;
import liga.medical.person_service.core.view.rest.controller.model.response.RoleResponse;
import liga.medical.person_service.core.mapper.RoleMapper;
import liga.medical.person_service.core.service.api.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
public class RoleController {
    private final RoleService service;
    private final RoleMapper mapper;

    @GetMapping("/{id}")
    public RoleResponse findById(@PathVariable @NotNull Long id) {
        RoleResponse roleResponse = mapper.toResponse(service.getById(id));
        log.info("Роль получена по ID: " + id);
        return roleResponse;
    }

    @GetMapping("/all")
    public List<RoleResponse> getAll() {
        List<RoleResponse> roleResponseList = service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        log.info("Получены все роли");
        return roleResponseList;
    }

    @PostMapping("/add")
    public RoleResponse add(@RequestBody RoleRequestForSave request) {
        RoleResponse roleResponse = mapper.toResponse(service.save(mapper.toDomain(request)));
        log.info("Добавлена роль: " + request);
        return roleResponse;
    }

    @PutMapping("/update")
    public RoleResponse update(@RequestBody RoleRequestForUpdate request) {
        RoleResponse roleResponse = mapper.toResponse(service.update(mapper.toDomain(request)));
        log.info("Роль с ID: " + request.getId() + " обновлена: " + request);
        return roleResponse;
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        Long deleteId = service.delete(id);
        log.info("Роль удалена, ID: " + id);
        return deleteId;
    }
}
