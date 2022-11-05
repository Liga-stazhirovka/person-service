package liga.medical.person_service.core.domain;

import lombok.*;

import java.sql.Date;
import java.time.ZonedDateTime;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Illness {
    private Long id;
    private Long medicalCardId;
    private Long typeId;
    private String heaviness;
    private ZonedDateTime appearanceDate;
    private Date recoveryDate;
}
