package liga.medical.person_service.core.controller;

import liga.medical.person_service.api.service.MedicalCardService;
import liga.medical.person_service.response.MedicalCardResponse;
import liga.medical.person_service.utils.mapper.MedicalCardMapper;
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
@RequestMapping("/medical-card")
public class MedicalCardController {
    private final MedicalCardService service;
    private final MedicalCardMapper mapper;

    @GetMapping("/id/{id}")
    public MedicalCardResponse findById(@PathVariable @NotNull Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @GetMapping("/all")
    public List<MedicalCardResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
