package liga.medical.person_service.core.view.rest.controller.model.request;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestForUpdate {
    private Long id;
    private String phoneNumber;
    private String email;
    private String profileLink;
}
