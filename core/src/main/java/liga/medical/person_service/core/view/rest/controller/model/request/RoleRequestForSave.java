package liga.medical.person_service.core.view.rest.controller.model.request;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleRequestForSave {

    private String name;
}