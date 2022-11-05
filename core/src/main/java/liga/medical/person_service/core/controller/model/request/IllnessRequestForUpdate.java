package liga.medical.person_service.core.controller.model.request;

import lombok.*;

import java.sql.Date;
import java.time.ZonedDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IllnessRequestForUpdate {
    private Long id;
    private Long medicalCardId;
    private Long typeId;
    private String heaviness;
    private ZonedDateTime appearanceDate;
    private Date recoveryDate;
}
