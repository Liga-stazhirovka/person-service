package liga.medical.person_service.core.controller.model.request;

import lombok.*;

import java.util.Set;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestForSave {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<RoleRequestForSave> roles;
}
