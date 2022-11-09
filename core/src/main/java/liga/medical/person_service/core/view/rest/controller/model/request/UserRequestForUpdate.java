package liga.medical.person_service.core.view.rest.controller.model.request;

import lombok.*;

import java.util.Set;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestForUpdate {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<RoleRequestForUpdate> roles;
}
