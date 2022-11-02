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
import java.util.stream.Collectors;

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
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto save(ContactDto dto) {
        Optional<ContactEntity> optionalContactEntity = repository.findById(dto.getId());
        if (optionalContactEntity.isPresent())
            throw new NotFoundException("Contact save error! Contact already exist with ID: " + dto.getId());
        repository.save(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public ContactDto update(ContactDto dto) {
        Optional<ContactEntity> optionalContactEntity = repository.findById(dto.getId());
        if (optionalContactEntity.isEmpty())
            throw new NotFoundException("Contact update error! Contact by Id not found, ID: " + dto.getId());
        repository.save(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public Long delete(Long id) {
        Optional<ContactEntity> optionalContactEntity = repository.findById(id);
        if (optionalContactEntity.isEmpty())
            throw new NotFoundException("Contact delete error! Contact by Id not found, ID: " + id);
        repository.delete(optionalContactEntity.get());
        return id;
    }
}
