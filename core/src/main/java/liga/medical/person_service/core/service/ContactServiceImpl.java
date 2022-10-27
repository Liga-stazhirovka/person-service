package liga.medical.person_service.core.service;

import liga.medical.person_service.api.repository.ContactRepository;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.dao.entity.ContactEntity;
import liga.medical.person_service.dto.ContactDto;
import liga.medical.person_service.utils.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl {
    private final ContactRepository repository;
    private final ContactMapper mapper;

    public ContactDto getById(Long id) {
        Optional<ContactEntity> optionalContactEntity = repository.findById(id);
        if (optionalContactEntity.isEmpty())
            throw new NotFoundException("Contact by Id not found, ID: " + id);
        return mapper.toDto(optionalContactEntity.get());
    }
}
