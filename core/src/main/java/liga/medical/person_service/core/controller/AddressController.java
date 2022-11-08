package liga.medical.person_service.core.controller;

import liga.medical.person_service.core.service.api.AddressService;
import liga.medical.person_service.core.controller.model.response.AddressResponse;
import liga.medical.person_service.core.mapper.AddressMapper;
import liga.medical.person_service.core.controller.model.request.AddressRequestForSave;
import liga.medical.person_service.core.controller.model.request.AddressRequestForUpdate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService service;
    private final AddressMapper mapper;

    @GetMapping("/{id}")
    public AddressResponse findById(@PathVariable @NotNull Long id) {
        AddressResponse addressResponse = mapper.toResponse(service.getById(id));
        log.info("Получен адрес по ID: " + id);
        return addressResponse;
    }

    @GetMapping("/all")
    public List<AddressResponse> getAll() {
        List<AddressResponse> addressResponses = service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        log.info("Получены все адреса");
        return addressResponses;
    }

    @PostMapping("/add")
    public AddressResponse add(@RequestBody AddressRequestForSave request) {
        AddressResponse addressResponse = mapper.toResponse(service.save(mapper.toDomain(request)));
        log.info("Адрес добавлен: " + request);
        return addressResponse;
    }

    @PutMapping("/update")
    public AddressResponse update(@RequestBody AddressRequestForUpdate request) {
        AddressResponse addressResponse = mapper.toResponse(service.update(mapper.toDomain(request)));
        log.info("Адрес с ID: " + request.getId() + ", обновлен: " + request);
        return addressResponse;
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        Long deleteId = service.delete(id);
        log.info("Адрес удален, ID: " + id);
        return deleteId;
    }
}
