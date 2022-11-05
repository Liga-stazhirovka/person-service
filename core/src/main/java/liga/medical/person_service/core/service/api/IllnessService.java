package liga.medical.person_service.core.service.api;

import liga.medical.person_service.core.domain.Illness;
import liga.medical.person_service.core.service.dto.IllnessDto;

import java.util.List;

public interface IllnessService {
    IllnessDto getById(Long id);

    List<IllnessDto> getAll();

    IllnessDto save(Illness illness);

    IllnessDto update(Illness illness);

    Long delete(Long id);
}

