package liga.medical.person_service.core.view.rest.controller.model.request;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestForUpdate {

    private Long id;

    private String name;
}
