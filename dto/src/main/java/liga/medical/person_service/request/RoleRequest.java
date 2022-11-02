package liga.medical.person_service.request;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequest {
    private Long id;
    private String roleName;
}
