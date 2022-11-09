package liga.medical.person_service.core.view.rest.controller;

import liga.medical.person_service.core.view.rest.controller.model.request.PersonDataRequestForSave;
import liga.medical.person_service.core.view.rest.controller.model.request.PersonDataRequestForUpdate;
import liga.medical.person_service.core.view.rest.controller.model.response.PersonDataResponse;
import liga.medical.person_service.core.mapper.PersonDataMapper;
import liga.medical.person_service.core.service.api.PersonDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/person-data")
public class PersonDataController {
    private final PersonDataService service;
    private final PersonDataMapper mapper;

    @GetMapping("/{id}")
    public PersonDataResponse findById(@PathVariable @NotNull Long id) {
        PersonDataResponse personDataResponse = mapper.toResponse(service.getById(id));
        log.info("Получены данные пациента по ID: " + id);
        return personDataResponse;
    }

    @GetMapping("/all")
    public List<PersonDataResponse> getAll() {
        List<PersonDataResponse> personDataResponses = service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        log.info("Получены данные всех пациентов");
        return personDataResponses;
    }

    @PostMapping("/add")
    public PersonDataResponse add(@RequestBody PersonDataRequestForSave request) {
        PersonDataResponse personDataResponse = mapper.toResponse(service.save(mapper.toDomain(request)));
        log.info("Добавлены персональные данные: " + request);
        return personDataResponse;
    }

    @PutMapping("/update")
    public PersonDataResponse update(@RequestBody PersonDataRequestForUpdate request) {
        PersonDataResponse personDataResponse = mapper.toResponse(service.update(mapper.toDomain(request)));
        log.info("Персональные данные с ID: " + request.getId() + " обновлены: " + request);
        return personDataResponse;
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        Long deleteId = service.delete(id);
        log.info("Персональные данные удалены, ID: " + id);
        return deleteId;
    }
}
