package liga.medical.person_service.api.service;

import liga.medical.person_service.dto.MedicalCardDto;

import java.util.List;

public interface MedicalCardService {
    MedicalCardDto getById(Long id);

    List<MedicalCardDto> getAll();

    MedicalCardDto save(MedicalCardDto dto);

    MedicalCardDto update(MedicalCardDto dto);

    Long delete(Long id);
}


