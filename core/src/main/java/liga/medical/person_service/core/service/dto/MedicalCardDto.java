package liga.medical.person_service.core.service.dto;

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
public class MedicalCardDto {
    private Long id;
    private String clientStatus;
    private String medStatus;
    private Date registryDate;
    private String comment;
}
