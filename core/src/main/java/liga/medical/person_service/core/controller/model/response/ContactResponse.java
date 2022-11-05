package liga.medical.person_service.core.controller.model.response;

import lombok.Getter;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {
    private Long id;
    private String phoneNumber;
    private String email;
    private String profileLink;
}
