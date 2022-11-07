package liga.medical.person_service.core.service;

import liga.medical.person_service.core.domain.MedicalCard;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.core.mapper.MedicalCardMapper;
import liga.medical.person_service.core.repository.MedicalCardRepository;
import liga.medical.person_service.core.repository.entity.entity.AddressEntity;
import liga.medical.person_service.core.repository.entity.entity.MedicalCardEntity;
import liga.medical.person_service.core.service.api.MedicalCardService;
import liga.medical.person_service.core.service.dto.MedicalCardDto;
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
            throw new NotFoundException("Medical card by Id not fount, Id: " + id);
        return mapper.toDto(optionalMedicalCardEntity.get());
    }

    @Override
    public List<MedicalCardDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MedicalCardDto save(MedicalCard medicalCard) {
        return mapper.toDto(repository.save(mapper.toEntity(buildMedicalCardDtoForSave(medicalCard))));
    }

    @Override
    public MedicalCardDto update(MedicalCard medicalCard) {
        return mapper.toDto(repository.save(mapper.toEntity(buildMedicalCardDtoForUpdate(medicalCard))));
    }

    @Override
    public Long delete(Long id) {
        Optional<MedicalCardEntity> optionalMedicalCardEntity = repository.findById(id);
        if (optionalMedicalCardEntity.isEmpty())
            throw new NotFoundException("Medical card delete error! Medical card by Id not fount, Id: " + id);
        repository.delete(optionalMedicalCardEntity.get());
        return id;
    }

    private MedicalCardDto buildMedicalCardDtoForSave(MedicalCard medicalCard) {
        return MedicalCardDto.builder()
                .clientStatus(medicalCard.getClientStatus())
                .medStatus(medicalCard.getMedStatus())
                .registryDate(medicalCard.getRegistryDate())
                .comment(medicalCard.getComment())
                .build();
    }

    private MedicalCardDto buildMedicalCardDtoForUpdate(MedicalCard medicalCard) {
        return MedicalCardDto.builder()
                .id(medicalCard.getId())
                .clientStatus(medicalCard.getClientStatus())
                .medStatus(medicalCard.getMedStatus())
                .registryDate(medicalCard.getRegistryDate())
                .comment(medicalCard.getComment())
                .build();
    }
}
