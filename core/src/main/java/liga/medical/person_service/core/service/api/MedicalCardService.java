package liga.medical.person_service.core.service.api;

import liga.medical.person_service.core.domain.MedicalCard;
import liga.medical.person_service.core.service.dto.MedicalCardDto;

import java.util.List;

public interface MedicalCardService {
    MedicalCardDto getById(Long id);

    List<MedicalCardDto> getAll();

    MedicalCardDto save(MedicalCard medicalCard);

    MedicalCardDto update(MedicalCard medicalCard);

    Long delete(Long id);
}


