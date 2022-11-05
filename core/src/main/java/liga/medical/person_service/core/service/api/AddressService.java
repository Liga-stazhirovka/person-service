package liga.medical.person_service.core.service.api;

import liga.medical.person_service.core.domain.Address;
import liga.medical.person_service.core.service.dto.AddressDto;

import java.util.List;

public interface AddressService {

    AddressDto getById(Long id);

    List<AddressDto> getAll();

    AddressDto save(Address dto);

    AddressDto update(Address dto);

    Long delete(Long id);
}

