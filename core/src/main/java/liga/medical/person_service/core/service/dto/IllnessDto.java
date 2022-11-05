package liga.medical.person_service.core.service.dto;

import lombok.*;

import java.sql.Date;
import java.time.ZonedDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IllnessDto {
    private Long id;
    private MedicalCardDto medicalCardDto;
    private Long typeId;
    private String heaviness;
    private ZonedDateTime appearanceDate;
    private Date recoveryDate;
}
