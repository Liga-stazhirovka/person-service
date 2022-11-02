package liga.medical.person_service.request;

import liga.medical.person_service.dto.ContactDto;
import liga.medical.person_service.dto.MedicalCardDto;
import lombok.*;

import java.sql.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonDataRequest {
    private Long id;
    private String lastName;
    private String firstName;
    private Date birthDay;
    private Byte age;
    private String sex;
    private Long contactId;
    private Long medicalCardId;
    private Long parentId;
}
