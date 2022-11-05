package liga.medical.person_service.core.controller;

import liga.medical.person_service.core.controller.model.request.IllnessRequestForSave;
import liga.medical.person_service.core.controller.model.request.IllnessRequestForUpdate;
import liga.medical.person_service.core.controller.model.response.IllnessResponse;
import liga.medical.person_service.core.mapper.IllnessMapper;
import liga.medical.person_service.core.service.api.IllnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/illness")
public class IllnessController {
    private final IllnessService service;
    private final IllnessMapper mapper;

    @GetMapping("/{id}")
    public IllnessResponse findById(@PathVariable @NotNull Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @GetMapping("/all")
    public List<IllnessResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public IllnessResponse add(@RequestBody IllnessRequestForSave request) {
        return mapper.toResponse(service.save(mapper.toDomain(request)));
    }

    @PutMapping("/update")
    public IllnessResponse update(@RequestBody IllnessRequestForUpdate request) {
        return mapper.toResponse(service.update(mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        return service.delete(id);
    }
}
