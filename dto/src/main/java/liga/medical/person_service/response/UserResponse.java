package liga.medical.person_service.response;

import liga.medical.person_service.dao.entity.RoleEntity;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Set<RoleEntity> roles = new HashSet<>();

}
