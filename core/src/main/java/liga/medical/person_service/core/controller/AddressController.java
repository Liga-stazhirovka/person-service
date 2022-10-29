package liga.medical.person_service.core.controller;

import liga.medical.person_service.api.service.AddressService;
import liga.medical.person_service.request.address.AddressSaveRequest;
import liga.medical.person_service.response.AddressResponse;
import liga.medical.person_service.utils.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService service;
    private final AddressMapper mapper;

    @GetMapping("/id/{id}")
    public AddressResponse findById(@PathVariable @NotNull Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @GetMapping("/all")
    public List<AddressResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }


}
