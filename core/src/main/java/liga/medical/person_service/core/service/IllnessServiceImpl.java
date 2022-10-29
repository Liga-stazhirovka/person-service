package liga.medical.person_service.core.service;

import liga.medical.person_service.api.repository.IllnessRepository;
import liga.medical.person_service.api.service.IllnessService;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.dao.entity.IllnessEntity;
import liga.medical.person_service.dto.IllnessDto;
import liga.medical.person_service.utils.mapper.IllnessMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IllnessServiceImpl implements IllnessService {
    private final IllnessRepository repository;
    private final IllnessMapper mapper;

    @Override
    public IllnessDto getById(Long id) {
        Optional<IllnessEntity> optionalIllnessEntity = repository.findById(id);
        if (optionalIllnessEntity.isEmpty())
            throw new NotFoundException("Illness by Id not found, Id: " + id);
        return mapper.toDto(optionalIllnessEntity.get());
    }

    @Override
    public List<IllnessDto> getAll() {
        return null;
    }

    @Override
    public IllnessDto save(IllnessDto dto) {
        return null;
    }

    @Override
    public IllnessDto update(IllnessDto dto) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
