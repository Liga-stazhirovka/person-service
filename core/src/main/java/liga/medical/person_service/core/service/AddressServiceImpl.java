package liga.medical.person_service.core.service;

import liga.medical.person_service.api.repository.AddressRepository;
import liga.medical.person_service.api.service.AddressService;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.dao.entity.AddressEntity;
import liga.medical.person_service.dto.AddressDto;
import liga.medical.person_service.utils.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    @Override
    public AddressDto getById(Long id) {
        Optional<AddressEntity> optionalAddressEntity = repository.findById(id);
        if (optionalAddressEntity.isEmpty())
            throw new NotFoundException("Address by Id not fount, Id: " + id);
        return mapper.toDto(optionalAddressEntity.get());
    }

    @Override
    public List<AddressDto> getAll() {
        return null;
    }

    @Override
    public AddressDto save(AddressDto dto) {
        return null;
    }

    @Override
    public AddressDto update(AddressDto dto) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
