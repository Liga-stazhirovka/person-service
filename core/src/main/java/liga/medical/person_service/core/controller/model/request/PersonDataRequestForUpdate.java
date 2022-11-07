package liga.medical.person_service.core.controller.model.request;

import lombok.*;

import java.sql.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonDataRequestForUpdate {
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
