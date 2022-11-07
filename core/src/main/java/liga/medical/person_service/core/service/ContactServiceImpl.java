package liga.medical.person_service.core.service;

import liga.medical.person_service.core.domain.Contact;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.core.mapper.ContactMapper;
import liga.medical.person_service.core.repository.ContactRepository;
import liga.medical.person_service.core.repository.entity.entity.ContactEntity;
import liga.medical.person_service.core.service.api.ContactService;
import liga.medical.person_service.core.service.dto.ContactDto;
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
            throw new NotFoundException("Contact by Id not fount, Id: " + id);
        return mapper.toDto(optionalContactEntity.get());
    }

    @Override
    public List<ContactDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDto save(Contact contact) {
        return mapper.toDto(repository.save(mapper.toEntity(buildContactDtoForSave(contact))));
    }

    @Override
    public ContactDto update(Contact contact) {
       return mapper.toDto(repository.save(mapper.toEntity(buildContactDtoForUpdate(contact))));
    }

    @Override
    public Long delete(Long id) {
        Optional<ContactEntity> optionalContactEntity = repository.findById(id);
        if (optionalContactEntity.isEmpty())
            throw new NotFoundException("Contact delete error, Contact by id not found, ID: " + id);
        repository.delete(optionalContactEntity.get());
        return id;
    }

    private ContactDto buildContactDtoForSave(Contact contact) {
        return ContactDto.builder()
                .phoneNumber(contact.getPhoneNumber())
                .email(contact.getEmail())
                .profileLink(contact.getProfileLink())
                .build();
    }

    private ContactDto buildContactDtoForUpdate(Contact contact) {
        return ContactDto.builder()
                .id(contact.getId())
                .phoneNumber(contact.getPhoneNumber())
                .email(contact.getEmail())
                .profileLink(contact.getProfileLink())
                .build();
    }
}
