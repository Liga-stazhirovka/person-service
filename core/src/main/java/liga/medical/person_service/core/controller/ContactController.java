package liga.medical.person_service.core.controller;

import liga.medical.person_service.core.controller.model.request.ContactRequestForSave;
import liga.medical.person_service.core.controller.model.request.ContactRequestForUpdate;
import liga.medical.person_service.core.controller.model.response.ContactResponse;
import liga.medical.person_service.core.mapper.ContactMapper;
import liga.medical.person_service.core.service.api.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {
    private final ContactService service;
    private final ContactMapper mapper;

    @GetMapping("/{id}")
    public ContactResponse findById(@PathVariable @NotNull Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @GetMapping("/all")
    public List<ContactResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ContactResponse add(@RequestBody ContactRequestForSave request) {
        return mapper.toResponse(service.save(mapper.toDomain(request)));
    }

    @PutMapping("/update")
    public ContactResponse update(@RequestBody ContactRequestForUpdate request) {
        return mapper.toResponse(service.update(mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        return service.delete(id);
    }
}
