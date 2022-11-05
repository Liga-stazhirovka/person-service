package liga.medical.person_service.core.controller.model.request;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestForSave {
    private String phoneNumber;
    private String email;
    private String profileLink;
}
