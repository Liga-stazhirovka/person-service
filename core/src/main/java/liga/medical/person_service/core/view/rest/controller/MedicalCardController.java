package liga.medical.person_service.core.view.rest.controller;

import liga.medical.person_service.core.view.rest.controller.model.request.MedicalCardRequestForSave;
import liga.medical.person_service.core.view.rest.controller.model.request.MedicalCardRequestForUpdate;
import liga.medical.person_service.core.view.rest.controller.model.response.MedicalCardResponse;
import liga.medical.person_service.core.mapper.MedicalCardMapper;
import liga.medical.person_service.core.service.api.MedicalCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/medical-card")
public class MedicalCardController {
    private final MedicalCardService service;
    private final MedicalCardMapper mapper;

    @GetMapping("/{id}")
    public MedicalCardResponse findById(@PathVariable @NotNull Long id) {
        MedicalCardResponse medicalCardResponse = mapper.toResponse(service.getById(id));
        log.info("Медицинская карта получена по ID: " + id);
        return medicalCardResponse;
    }

    @GetMapping("/all")
    public List<MedicalCardResponse> getAll() {
        List<MedicalCardResponse> medicalCardResponses = service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        log.info("Получены все медицинские карты");
        return medicalCardResponses;
    }

    @PostMapping("/add")
    public MedicalCardResponse add(@RequestBody MedicalCardRequestForSave request) {
        MedicalCardResponse medicalCardResponse = mapper.toResponse(service.save(mapper.toDomain(request)));
        log.info("Добавлена медицинская карта: " + request);
        return medicalCardResponse;
    }

    @PutMapping("/update")
    public MedicalCardResponse update(@RequestBody MedicalCardRequestForUpdate request) {
        MedicalCardResponse medicalCardResponse = mapper.toResponse(service.update(mapper.toDomain(request)));
        log.info("Медицинская карта с ID: " + request.getId() + " обновлена: " + request);
        return medicalCardResponse;
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        Long deleteId = service.delete(id);
        log.info("Медицинская карта удалена, ID: " + id);
        return deleteId;
    }
}
