package liga.medical.person_service.core.view.rest.controller;

import liga.medical.person_service.core.view.rest.controller.model.request.UserRequestForSave;
import liga.medical.person_service.core.view.rest.controller.model.request.UserRequestForUpdate;
import liga.medical.person_service.core.view.rest.controller.model.response.UserResponse;
import liga.medical.person_service.core.mapper.UserMapper;
import liga.medical.person_service.core.service.api.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService service;
    private final UserMapper mapper;

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable @NotNull Long id) {
        UserResponse userResponse = mapper.toResponse(service.getById(id));
        log.info("Получен пользователь по ID: " + id);
        return userResponse;
    }

    @GetMapping("/all")
    public List<UserResponse> getAll() {
        List<UserResponse> userResponseList = service.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        log.info("Получены все пользователи");
        return userResponseList;
    }

    @PostMapping("/add")
    public UserResponse add(@RequestBody @Valid UserRequestForSave request) {
        UserResponse userResponse = mapper.toResponse(service.save(mapper.toDomain(request)));
        log.info("Добавлен пользователь: " + request);
        return userResponse;
    }

    @PutMapping("/update")
    public UserResponse update(@RequestBody UserRequestForUpdate request) {
        UserResponse userResponse = mapper.toResponse(service.update(mapper.toDomain(request)));
        log.info("Пользователь с ID: " + request.getId() + " обновлен: " + request);
        return userResponse;
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable @NotNull Long id) {
        Long deleteId = service.delete(id);
        log.info("Пользователь удален, ID: " + id);
        return deleteId;
    }
}
