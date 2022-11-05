package liga.medical.person_service.core.service.api;

import liga.medical.person_service.core.domain.PersonData;
import liga.medical.person_service.core.service.dto.PersonDataDto;

import java.util.List;

public interface PersonDataService {
    PersonDataDto getById(Long id);

    List<PersonDataDto> getAll();

    PersonDataDto save(PersonData personData);

    PersonDataDto update(PersonData personData);

    Long delete(Long id);
}

