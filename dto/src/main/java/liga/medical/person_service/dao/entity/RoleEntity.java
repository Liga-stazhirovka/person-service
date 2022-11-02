package liga.medical.person_service.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor()
@AllArgsConstructor
@Table(name = "roles")
public class RoleEntity {

    @Id
    @Column(name = "roles_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "role_name")
    private String roleName;
}
