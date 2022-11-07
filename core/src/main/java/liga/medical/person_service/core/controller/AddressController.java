package liga.medical.person_service.core.controller;

import liga.medical.person_service.core.service.api.AddressService;
import liga.medical.person_service.core.controller.model.response.AddressResponse;
import liga.medical.person_service.core.mapper.AddressMapper;
import liga.medical.person_service.core.controller.model.request.AddressRequestForSave;
import liga.medical.person_service.core.controller.model.request.AddressRequestForUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService service;
    private final AddressMapper mapper;

    @GetMapping("/{id}")
    public AddressResponse findById(@PathVariable @NotNull Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @GetMapping("/all")
    public List<AddressResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public AddressResponse add(@RequestBody AddressRequestForSave request) {
        return mapper.toResponse(service.save(mapper.toDomain(request)));
    }

    @PutMapping("/update")
    public AddressResponse update(@RequestBody AddressRequestForUpdate request) {
        return mapper.toResponse(service.update(mapper.toDomain(request)));
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        return service.delete(id);
    }
}
