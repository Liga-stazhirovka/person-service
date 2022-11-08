package liga.medical.person_service.core.controller;

import liga.medical.person_service.core.controller.model.request.IllnessRequestForSave;
import liga.medical.person_service.core.controller.model.request.IllnessRequestForUpdate;
import liga.medical.person_service.core.controller.model.response.IllnessResponse;
import liga.medical.person_service.core.mapper.IllnessMapper;
import liga.medical.person_service.core.service.api.IllnessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/illness")
public class IllnessController {
    private final IllnessService service;
    private final IllnessMapper mapper;

    @GetMapping("/{id}")
    public IllnessResponse findById(@PathVariable @NotNull Long id) {
        IllnessResponse illnessResponse = mapper.toResponse(service.getById(id));
        log.info("Болезнь по ID: " + id + " получена");
        return illnessResponse;
    }

    @GetMapping("/all")
    public List<IllnessResponse> getAll() {
        List<IllnessResponse> illnessResponses = service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        log.info("Получены все болезни");
        return illnessResponses;
    }

    @PostMapping("/add")
    public IllnessResponse add(@RequestBody IllnessRequestForSave request) {
        IllnessResponse illnessResponse = mapper.toResponse(service.save(mapper.toDomain(request)));
        log.info("Болезнь добавлена: " + request);
        return illnessResponse;
    }

    @PutMapping("/update")
    public IllnessResponse update(@RequestBody IllnessRequestForUpdate request) {
        IllnessResponse illnessResponse = mapper.toResponse(service.update(mapper.toDomain(request)));
        log.info("Болезнь с ID: " + request.getId() + " обновлена: " + request);
        return illnessResponse;
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        Long deleteId = service.delete(id);
        log.info("Болезнь удалена, ID: " + id);
        return deleteId;
    }
}
