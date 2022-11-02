package liga.medical.person_service.request;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequest {
    private Long id;
    private String phoneNumber;
    private String email;
    private String profileLink;
}
