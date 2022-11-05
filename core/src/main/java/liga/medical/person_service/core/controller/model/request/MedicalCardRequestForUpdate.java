package liga.medical.person_service.core.controller.model.request;

import lombok.*;

import java.sql.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardRequestForUpdate {
    private Long id;
    private String clientStatus;
    private String medStatus;
    private Date registryDate;
    private String comment;
}
