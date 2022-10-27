package liga.medical.person_service.core.service;

import liga.medical.person_service.api.repository.AddressRepository;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.dao.entity.AddressEntity;
import liga.medical.person_service.dto.AddressDto;
import liga.medical.person_service.utils.mapper.AddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    public AddressDto getById(Long id) {
        Optional<AddressEntity> optionalAddressEntity = repository.findById(id);
        if (optionalAddressEntity.isEmpty())
            throw new NotFoundException("Address by Id not fount, Id: " + id);
        return mapper.toDto(optionalAddressEntity.get());
    }
}
