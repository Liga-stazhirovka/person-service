package liga.medical.person_service.core.service.dto;

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
public class ContactDto {
    private Long id;
    private String phoneNumber;
    private String email;
    private String profileLink;
}
