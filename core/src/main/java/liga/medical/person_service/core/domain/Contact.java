package liga.medical.person_service.core.domain;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Long id;
    private String phoneNumber;
    private String email;
    private String profileLink;
}
