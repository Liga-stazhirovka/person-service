package liga.medical.person_service.api.service;

import liga.medical.person_service.dto.PersonDataDto;

import java.util.List;

public interface PersonDataService {
    PersonDataDto getById(Long id);

    List<PersonDataDto> getAll();

    PersonDataDto save(PersonDataDto dto);

    PersonDataDto update(PersonDataDto dto);

    Long delete(Long id);
}

