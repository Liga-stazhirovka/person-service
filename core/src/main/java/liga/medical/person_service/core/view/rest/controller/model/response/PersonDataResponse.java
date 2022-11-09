package liga.medical.person_service.core.view.rest.controller.model.response;

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
    private ContactResponse contactResponse;
    private MedicalCardResponse medicalCardResponse;
    private PersonDataResponse parent;
}
