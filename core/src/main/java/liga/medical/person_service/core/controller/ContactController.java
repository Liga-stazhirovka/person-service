package liga.medical.person_service.core.controller;

import liga.medical.person_service.core.controller.model.request.ContactRequestForSave;
import liga.medical.person_service.core.controller.model.request.ContactRequestForUpdate;
import liga.medical.person_service.core.controller.model.response.ContactResponse;
import liga.medical.person_service.core.mapper.ContactMapper;
import liga.medical.person_service.core.service.api.ContactService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/contact")
public class ContactController {
    private final ContactService service;
    private final ContactMapper mapper;

    @GetMapping("/{id}")
    public ContactResponse findById(@PathVariable @NotNull Long id) {
        ContactResponse contactResponse = mapper.toResponse(service.getById(id));
        log.info("Получен контакт по ID: " + id);
        return contactResponse;
    }

    @GetMapping("/all")
    public List<ContactResponse> getAll() {
        List<ContactResponse> contactResponses = service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        log.info("Получены все контакты");
        return contactResponses;
    }

    @PostMapping("/add")
    public ContactResponse add(@RequestBody ContactRequestForSave request) {
        ContactResponse contactResponse = mapper.toResponse(service.save(mapper.toDomain(request)));
        log.info("Контакт добавлен: " + request);
        return contactResponse;
    }

    @PutMapping("/update")
    public ContactResponse update(@RequestBody ContactRequestForUpdate request) {
        ContactResponse contactResponse = mapper.toResponse(service.update(mapper.toDomain(request)));
        log.info("Контакт с ID: " + request.getId() + ", обновлен: " + request);
        return contactResponse;
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        Long deleteId = service.delete(id);
        log.info("Контакт удален: " + id);
        return deleteId;
    }
}
