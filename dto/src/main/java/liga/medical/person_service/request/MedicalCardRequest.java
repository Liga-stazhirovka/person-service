package liga.medical.person_service.request;

import lombok.*;

import java.sql.Date;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicalCardRequest {
    private Long id;
    private String clientStatus;
    private String medStatus;
    private Date registryDate;
    private String comment;
}
