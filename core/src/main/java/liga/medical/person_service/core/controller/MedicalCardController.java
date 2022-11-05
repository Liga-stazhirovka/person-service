package liga.medical.person_service.core.controller;

import liga.medical.person_service.core.controller.model.request.MedicalCardRequestForSave;
import liga.medical.person_service.core.controller.model.request.MedicalCardRequestForUpdate;
import liga.medical.person_service.core.controller.model.response.MedicalCardResponse;
import liga.medical.person_service.core.mapper.MedicalCardMapper;
import liga.medical.person_service.core.service.api.MedicalCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/medical-card")
public class MedicalCardController {
    private final MedicalCardService service;
    private final MedicalCardMapper mapper;

    @GetMapping("/{id}")
    public MedicalCardResponse findById(@PathVariable @NotNull Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @GetMapping("/all")
    public List<MedicalCardResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public MedicalCardResponse add(@RequestBody MedicalCardRequestForSave request) {
        return mapper.toResponse(service.save(mapper.toDomain(request)));
    }

    @PutMapping("/update")
    public MedicalCardResponse update(@RequestBody MedicalCardRequestForUpdate request) {
        return mapper.toResponse(service.update(mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        return service.delete(id);
    }
}
