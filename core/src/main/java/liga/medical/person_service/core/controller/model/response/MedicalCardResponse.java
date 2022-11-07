package liga.medical.person_service.core.controller.model.response;

import lombok.Getter;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardResponse {
    private Long id;
    private String clientStatus;
    private String medStatus;
    private Date registryDate;
    private String comment;
}
