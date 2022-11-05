package liga.medical.person_service.core.domain;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    private Long id;

    private String name;
}
