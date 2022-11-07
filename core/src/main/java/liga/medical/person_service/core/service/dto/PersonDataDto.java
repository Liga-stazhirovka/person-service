package liga.medical.person_service.core.service.dto;

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
public class PersonDataDto {
    private Long id;
    private String lastName;
    private String firstName;
    private Date birthDay;
    private Byte age;
    private String sex;
    private ContactDto contactDto;
    private MedicalCardDto medicalCardDto;
    private PersonDataDto parent;
}
