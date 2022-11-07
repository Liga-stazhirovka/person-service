package liga.medical.person_service.core.controller;

import liga.medical.person_service.core.controller.model.request.UserRequestForSave;
import liga.medical.person_service.core.controller.model.response.UserResponse;
import liga.medical.person_service.core.mapper.UserMapper;
import liga.medical.person_service.core.service.api.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthorizationController {
    private final UserService service;
    private final UserMapper mapper;

    @PostMapping("/registration")
    public UserResponse registration(@RequestBody @Valid UserRequestForSave request) {
        return mapper.toResponse(service.save(mapper.toDomain(request)));
    }
}
