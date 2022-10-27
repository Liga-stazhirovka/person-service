package liga.medical.person_service.core.service;

import liga.medical.person_service.api.repository.PersonDataRepository;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.dao.entity.PersonDataEntity;
import liga.medical.person_service.dto.PersonDataDto;
import liga.medical.person_service.utils.mapper.PersonDataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonDataServiceImpl {
    private final PersonDataRepository repository;
    private final PersonDataMapper mapper;

    public PersonDataDto getById(Long id) {
        Optional<PersonDataEntity> optionalPersonDataEntity = repository.findById(id);
        if (optionalPersonDataEntity.isEmpty())
            throw new NotFoundException("Person data by Id not found, ID: " + id);
        return mapper.toDto(optionalPersonDataEntity.get());
    }
}
