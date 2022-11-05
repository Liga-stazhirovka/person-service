package liga.medical.person_service.core.controller.model.request;

import liga.medical.person_service.core.service.dto.RoleDto;
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
