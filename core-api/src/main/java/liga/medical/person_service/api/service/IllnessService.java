package liga.medical.person_service.api.service;

import liga.medical.person_service.dto.IllnessDto;

import java.util.List;

public interface IllnessService {
    IllnessDto getById(Long id);

    List<IllnessDto> getAll();

    IllnessDto save(IllnessDto dto);

    IllnessDto update(IllnessDto dto);

    Long delete(Long id);
}

