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
import java.util.stream.Collectors;

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
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IllnessDto save(IllnessDto dto) {
        Optional<IllnessEntity> optionalIllnessEntity = repository.findById(dto.getId());
        if (optionalIllnessEntity.isPresent())
            throw new NotFoundException("Illness save error! Illness already exist with Id: " + dto.getId());
        repository.save(mapper.toEntity(dto));
        return dto;
    }

    @Override
    public IllnessDto update(IllnessDto dto) {
        Optional<IllnessEntity> optionalIllnessEntity = repository.findById(dto.getId());
        if (optionalIllnessEntity.isEmpty())
            throw new NotFoundException("Illness update error! Illness by Id not found, Id: " + dto.getId());
        repository.save(mapper.toEntity(dto));
        return mapper.toDto(optionalIllnessEntity.get());
    }

    @Override
    public Long delete(Long id) {
        Optional<IllnessEntity> optionalIllnessEntity = repository.findById(id);
        if (optionalIllnessEntity.isEmpty())
            throw new NotFoundException("Illness delete error! Illness by Id not found, Id: " + id);
        repository.delete(optionalIllnessEntity.get());
        return id;
    }
}
