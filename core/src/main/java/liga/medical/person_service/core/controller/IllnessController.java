package liga.medical.person_service.core.controller;

import liga.medical.person_service.api.service.IllnessService;
import liga.medical.person_service.response.IllnessResponse;
import liga.medical.person_service.utils.mapper.IllnessMapper;
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
@RequestMapping("/illness")
public class IllnessController {
    private final IllnessService service;
    private final IllnessMapper mapper;

    @GetMapping("/id/{id}")
    public IllnessResponse findById(@PathVariable @NotNull Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @GetMapping("/all")
    public List<IllnessResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }
}
