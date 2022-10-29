package liga.medical.person_service.response;

import liga.medical.person_service.dto.ContactDto;
import liga.medical.person_service.dto.MedicalCardDto;

import lombok.Getter;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonDataResponse {
    private Long id;
    private String lastName;
    private String firstName;
    private Date birthDay;
    private Byte age;
    private String sex;
    private ContactDto contactEntity;
    private MedicalCardDto medicalCardEntity;
    private Long parentId;
}
