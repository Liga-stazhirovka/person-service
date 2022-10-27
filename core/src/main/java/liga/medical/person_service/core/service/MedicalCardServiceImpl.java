package liga.medical.person_service.core.service;

import liga.medical.person_service.api.repository.MedicalCardRepository;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.dao.entity.MedicalCardEntity;
import liga.medical.person_service.dto.MedicalCardDto;
import liga.medical.person_service.utils.mapper.MedicalCardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MedicalCardServiceImpl {
    private final MedicalCardRepository repository;
    private final MedicalCardMapper mapper;

    public MedicalCardDto getById(Long id) {
        Optional<MedicalCardEntity> optionalMedicalCardEntity = repository.findById(id);
        if (optionalMedicalCardEntity.isEmpty())
            throw new NotFoundException("Medical card by Id not found, ID: " + id);
        return mapper.toDto(optionalMedicalCardEntity.get());
    }
}
