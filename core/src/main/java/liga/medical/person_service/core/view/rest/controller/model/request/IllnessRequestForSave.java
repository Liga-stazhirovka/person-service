package liga.medical.person_service.core.view.rest.controller.model.request;

import lombok.*;

import java.sql.Date;
import java.time.ZonedDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IllnessRequestForSave {
    private Long medicalCardId;
    private Long typeId;
    private String heaviness;
    private ZonedDateTime appearanceDate;
    private Date recoveryDate;
}
