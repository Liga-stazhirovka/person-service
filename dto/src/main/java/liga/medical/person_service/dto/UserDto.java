package liga.medical.person_service.dto;

import liga.medical.person_service.dao.entity.RoleEntity;
import lombok.Getter;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String password;
    private Set<RoleEntity> roles = new HashSet<>();

}
