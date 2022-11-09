package liga.medical.person_service.core.view.rest.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestForSave {
    @Size(min = 5, message = "Имя должно быть больше 5 символов ")
    private String firstName;
    @Size(min = 5, message = "Фамилия должна быть больше 5 символов ")
    private String lastName;
    @Size(min = 9, message = "Email должен быть больше 8 символов ")
    private String email;
    @Size(min = 9, message = "Пароль должно быть больше 8 символов ")
    private String password;
    private Set<RoleRequestForSave> roles;
}
