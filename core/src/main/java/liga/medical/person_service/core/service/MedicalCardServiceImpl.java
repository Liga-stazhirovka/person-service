package liga.medical.person_service.core.service;

import liga.medical.person_service.api.repository.MedicalCardRepository;
import liga.medical.person_service.api.service.MedicalCardService;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.dao.entity.MedicalCardEntity;
import liga.medical.person_service.dto.MedicalCardDto;
import liga.medical.person_service.utils.mapper.MedicalCardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalCardServiceImpl implements MedicalCardService {
    private final MedicalCardRepository repository;
    private final MedicalCardMapper mapper;

    @Override
    public MedicalCardDto getById(Long id) {
        Optional<MedicalCardEntity> optionalMedicalCardEntity = repository.findById(id);
        if (optionalMedicalCardEntity.isEmpty())
            throw new NotFoundException("Medical card by Id not found, ID: " + id);
        return mapper.toDto(optionalMedicalCardEntity.get());
    }

    @Override
    public List<MedicalCardDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MedicalCardDto save(MedicalCardDto dto) {
        Optional<MedicalCardEntity> optionalMedicalCardEntity = repository.findById(dto.getId());
        if (optionalMedicalCardEntity.isPresent())
            throw new NotFoundException("Medical card save error! Medical card already exist with ID: " + dto.getId());
        repository.save(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public MedicalCardDto update(MedicalCardDto dto) {
        Optional<MedicalCardEntity> optionalMedicalCardEntity = repository.findById(dto.getId());
        if (optionalMedicalCardEntity.isEmpty())
            throw new NotFoundException("Medical card update error! Medical card by Id not found, ID: " + dto.getId());
        repository.save(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public Long delete(Long id) {
        Optional<MedicalCardEntity> optionalMedicalCardEntity = repository.findById(id);
        if (optionalMedicalCardEntity.isEmpty())
            throw new NotFoundException("Medical card delete error! Medical card by Id not found, ID: " + id);
        repository.delete(optionalMedicalCardEntity.get());
        return id;
    }
}
