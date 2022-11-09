package liga.medical.person_service.core.view.rest.controller.model.response;

import lombok.Getter;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Date;
import java.time.ZonedDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IllnessResponse {
    private Long id;
    private MedicalCardResponse medicalCardResponse;
    private Long typeId;
    private String heaviness;
    private ZonedDateTime appearanceDate;
    private Date recoveryDate;
}

