package liga.medical.person_service.core.controller.model.response;

import liga.medical.person_service.core.service.dto.RoleDto;
import lombok.*;

import java.util.Set;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<RoleResponse> roles;
}
