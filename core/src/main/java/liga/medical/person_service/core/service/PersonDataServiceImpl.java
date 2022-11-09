package liga.medical.person_service.core.service;

import liga.medical.person_service.core.domain.PersonData;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.core.mapper.PersonDataMapper;
import liga.medical.person_service.core.dao.repository.PersonDataRepository;
import liga.medical.person_service.core.dao.repository.entity.entity.PersonDataEntity;
import liga.medical.person_service.core.service.api.ContactService;
import liga.medical.person_service.core.service.api.MedicalCardService;
import liga.medical.person_service.core.service.api.PersonDataService;
import liga.medical.person_service.core.service.dto.ContactDto;
import liga.medical.person_service.core.service.dto.MedicalCardDto;
import liga.medical.person_service.core.service.dto.PersonDataDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonDataServiceImpl implements PersonDataService {
    private final PersonDataRepository repository;
    private final PersonDataMapper mapper;
    private final ContactService contactService;
    private final MedicalCardService medicalCardService;


    @Override
    public PersonDataDto getById(Long id) {
        Optional<PersonDataEntity> optionalPersonDataEntity = repository.findById(id);
        if (optionalPersonDataEntity.isEmpty())
            throw new NotFoundException("Person data by Id not fount, Id: " + id);
        return mapper.toDto(optionalPersonDataEntity.get());
    }

    @Override
    public List<PersonDataDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDataDto save(PersonData personData) {
        return mapper.toDto(repository.save(mapper.toEntity(findDependenciesAndBuildPersonDataDtoForSave(personData))));
    }

    @Override
    public PersonDataDto update(PersonData personData) {
        return mapper.toDto(repository.save(mapper.toEntity(findDependenciesAndBuildPersonDataDtoForUpdate(personData))));
    }

    @Override
    public Long delete(Long id) {
        Optional<PersonDataEntity> optionalPersonDataEntity = repository.findById(id);
        if (optionalPersonDataEntity.isEmpty())
            throw new NotFoundException("Person data delete error! Person data by Id not fount, Id: " + id);
        repository.delete(optionalPersonDataEntity.get());
        return id;
    }

    private PersonDataDto findDependenciesAndBuildPersonDataDtoForSave(PersonData personData) {
        ContactDto contactDto = contactService.getById(personData.getId());
        MedicalCardDto medicalCardDto = medicalCardService.getById(personData.getId());
        PersonDataDto parent = this.getById(personData.getParentId());
        return PersonDataDto.builder()
                .lastName(personData.getLastName())
                .firstName(personData.getFirstName())
                .birthDay(personData.getBirthDay())
                .age(personData.getAge())
                .sex(personData.getSex())
                .contactDto(contactDto)
                .medicalCardDto(medicalCardDto)
                .parent(parent)
                .build();
    }

    private PersonDataDto findDependenciesAndBuildPersonDataDtoForUpdate(PersonData personData) {
        ContactDto contactDto = contactService.getById(personData.getId());
        MedicalCardDto medicalCardDto = medicalCardService.getById(personData.getId());
        PersonDataDto parent = this.getById(personData.getParentId());
        return PersonDataDto.builder()
                .id(personData.getId())
                .lastName(personData.getLastName())
                .firstName(personData.getFirstName())
                .birthDay(personData.getBirthDay())
                .age(personData.getAge())
                .sex(personData.getSex())
                .contactDto(contactDto)
                .medicalCardDto(medicalCardDto)
                .parent(parent)
                .build();
    }
}
