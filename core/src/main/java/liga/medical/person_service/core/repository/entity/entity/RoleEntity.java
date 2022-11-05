package liga.medical.person_service.core.repository.entity.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class RoleEntity implements GrantedAuthority {

    @Id
    @Column(name = "roles_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "role_name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private Set<UserEntity> users;

    @Override
    public String getAuthority() {
        return name;
    }
}