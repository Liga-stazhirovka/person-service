package liga.medical.person_service.core.service;

import liga.medical.person_service.core.domain.Illness;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.core.mapper.IllnessMapper;
import liga.medical.person_service.core.dao.repository.IllnessRepository;
import liga.medical.person_service.core.dao.repository.entity.entity.IllnessEntity;
import liga.medical.person_service.core.service.api.IllnessService;
import liga.medical.person_service.core.service.api.MedicalCardService;
import liga.medical.person_service.core.service.dto.IllnessDto;
import liga.medical.person_service.core.service.dto.MedicalCardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IllnessServiceImpl implements IllnessService {
    private final IllnessRepository repository;
    private final IllnessMapper mapper;
    private final MedicalCardService medicalCardService;

    @Override
    public IllnessDto getById(Long id) {
        Optional<IllnessEntity> optionalIllnessEntity = repository.findById(id);
        if (optionalIllnessEntity.isEmpty())
            throw new NotFoundException("Illness by Id not fount, Id: " + id);
        return mapper.toDto(optionalIllnessEntity.get());
    }

    @Override
    public List<IllnessDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IllnessDto save(Illness illness) {
        return mapper.toDto(repository.save(mapper.toEntity(findMedicalCardAndBuildIllnessDtoForSave(illness))));
    }

    @Override
    public IllnessDto update(Illness illness) {
        return mapper.toDto(repository.save(mapper.toEntity(findMedicalCardAndBuildIllnessDtoForUpdate(illness))));
    }

    @Override
    public Long delete(Long id) {
        Optional<IllnessEntity> optionalIllnessEntity = repository.findById(id);
        if (optionalIllnessEntity.isEmpty())
            throw new NotFoundException("Illness delete error! Illness by Id not fount, Id: " + id);
        repository.delete(optionalIllnessEntity.get());
        return id;
    }

    private IllnessDto findMedicalCardAndBuildIllnessDtoForSave(Illness illness) {
        MedicalCardDto medicalCardDto = medicalCardService.getById(illness.getId());
        return IllnessDto.builder()
                .typeId(illness.getTypeId())
                .medicalCardDto(medicalCardDto)
                .heaviness(illness.getHeaviness())
                .appearanceDate(illness.getAppearanceDate())
                .recoveryDate(illness.getRecoveryDate())
                .build();
    }

    private IllnessDto findMedicalCardAndBuildIllnessDtoForUpdate(Illness illness) {
        MedicalCardDto medicalCardDto = medicalCardService.getById(illness.getId());
        return IllnessDto.builder()
                .id(illness.getId())
                .typeId(illness.getTypeId())
                .medicalCardDto(medicalCardDto)
                .heaviness(illness.getHeaviness())
                .appearanceDate(illness.getAppearanceDate())
                .recoveryDate(illness.getRecoveryDate())
                .build();
    }
}
