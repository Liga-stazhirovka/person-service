package liga.medical.person_service.core.service;

import liga.medical.person_service.api.repository.ContactRepository;
import liga.medical.person_service.api.service.ContactService;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.dao.entity.ContactEntity;
import liga.medical.person_service.dto.ContactDto;
import liga.medical.person_service.utils.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepository repository;
    private final ContactMapper mapper;

    @Override
    public ContactDto getById(Long id) {
        Optional<ContactEntity> optionalContactEntity = repository.findById(id);
        if (optionalContactEntity.isEmpty())
            throw new NotFoundException("Contact by Id not found, ID: " + id);
        return mapper.toDto(optionalContactEntity.get());
    }

    @Override
    public List<ContactDto> getAll() {
        return null;
    }

    @Override
    public ContactDto save(ContactDto dto) {
        return null;
    }

    @Override
    public ContactDto update(ContactDto dto) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
