package liga.medical.person_service.core.controller;

import liga.medical.person_service.api.service.UserService;
import liga.medical.person_service.dto.UserLogin;
import liga.medical.person_service.dto.UserRegistration;
import liga.medical.person_service.response.UserResponse;
import liga.medical.person_service.utils.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/id/{id}")
    public UserResponse getById(@PathVariable Long id) {
        return mapper.toResponse(service.getById(id));
    }

    @GetMapping("/getAll")
    public List<UserResponse> getAll() {
        return service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @PostMapping("/login")
    public UserResponse login(UserLogin userLogin) {
        return mapper.toResponse(service.login(userLogin));
    }

    @PostMapping("/registration")
    public UserResponse signUp(UserRegistration userRegistration) {
        return mapper.toResponse(service.signUp(userRegistration));
    }
}
