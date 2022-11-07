package liga.medical.person_service.core.domain;

import lombok.*;

import java.sql.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCard {
    private Long id;
    private String clientStatus;
    private String medStatus;
    private Date registryDate;
    private String comment;
}
