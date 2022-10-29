package liga.medical.person_service.response;

import liga.medical.person_service.dto.MedicalCardDto;

import lombok.Getter;
import lombok.Builder;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IllnessResponse {
    private Long id;
    private MedicalCardDto medicalCardEntity;
    private Long typeId;
    private String heaviness;
    private Timestamp appearanceDate;
    private Date recoveryDate;
}