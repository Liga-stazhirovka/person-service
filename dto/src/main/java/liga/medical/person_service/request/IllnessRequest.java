package liga.medical.person_service.request;

import liga.medical.person_service.dto.MedicalCardDto;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IllnessRequest {
    private Long id;
    private Long medicalCardEntityId;
    private Long typeId;
    private String heaviness;
    private Timestamp appearanceDate;
    private Date recoveryDate;
}
