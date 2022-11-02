package liga.medical.person_service.api.service;

import liga.medical.person_service.dto.ContactDto;

import java.util.List;

public interface ContactService {
    ContactDto getById(Long id);

    List<ContactDto> getAll();

    ContactDto save(ContactDto dto);

    ContactDto update(ContactDto dto);

    Long delete(Long id);
}
