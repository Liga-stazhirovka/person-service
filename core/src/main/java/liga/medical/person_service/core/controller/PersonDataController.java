package liga.medical.person_service.core.controller;

import liga.medical.person_service.api.service.PersonDataService;
import liga.medical.person_service.response.PersonDataResponse;
import liga.medical.person_service.utils.mapper.PersonDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person-data")
public class PersonDataController {
    private final PersonDataService service;
    private final PersonDataMapper mapper;

    @GetMapping("/id/{id}")
    public PersonDataResponse findById(@PathVariable @NotNull Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @GetMapping("/all")
    public List<PersonDataResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
