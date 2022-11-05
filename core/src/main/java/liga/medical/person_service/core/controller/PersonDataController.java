package liga.medical.person_service.core.controller;

import liga.medical.person_service.core.controller.model.request.AddressRequestForSave;
import liga.medical.person_service.core.controller.model.request.AddressRequestForUpdate;
import liga.medical.person_service.core.controller.model.request.PersonDataRequestForSave;
import liga.medical.person_service.core.controller.model.request.PersonDataRequestForUpdate;
import liga.medical.person_service.core.controller.model.response.AddressResponse;
import liga.medical.person_service.core.service.api.PersonDataService;
import liga.medical.person_service.core.controller.model.response.PersonDataResponse;
import liga.medical.person_service.core.mapper.PersonDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person-data")
public class PersonDataController {
    private final PersonDataService service;
    private final PersonDataMapper mapper;

    @GetMapping("/{id}")
    public PersonDataResponse findById(@PathVariable @NotNull Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @GetMapping("/all")
    public List<PersonDataResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public PersonDataResponse add(@RequestBody PersonDataRequestForSave request) {
        return mapper.toResponse(service.save(mapper.toDomain(request)));
    }

    @PutMapping("/update")
    public PersonDataResponse update(@RequestBody PersonDataRequestForUpdate request) {
        return mapper.toResponse(service.update(mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        return service.delete(id);
    }
}
