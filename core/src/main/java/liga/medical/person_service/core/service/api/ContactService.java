package liga.medical.person_service.core.service.api;

import liga.medical.person_service.core.domain.Contact;
import liga.medical.person_service.core.service.dto.ContactDto;

import java.util.List;

public interface ContactService {
    ContactDto getById(Long id);

    List<ContactDto> getAll();

    ContactDto save(Contact contact);

    ContactDto update(Contact contact);

    Long delete(Long id);
}
