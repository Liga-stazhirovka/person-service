package liga.medical.person_service.core.service;

import liga.medical.person_service.api.repository.IllnessRepository;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.dao.entity.IllnessEntity;
import liga.medical.person_service.dto.IllnessDto;
import liga.medical.person_service.utils.mapper.IllnessMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IllnessServiceImpl {
    private final IllnessRepository repository;
    private final IllnessMapper mapper;

    public IllnessDto getById(Long id) {
        Optional<IllnessEntity> optionalIllnessEntity = repository.findById(id);
        if (optionalIllnessEntity.isEmpty())
            throw new NotFoundException("Illness by Id not found, Id: " + id);
        return mapper.toDto(optionalIllnessEntity.get());
    }
}
