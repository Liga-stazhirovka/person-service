package liga.medical.person_service.core.view.rest.controller.model.request;

import lombok.*;

import java.sql.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardRequestForSave {
    private String clientStatus;
    private String medStatus;
    private Date registryDate;
    private String comment;
}
