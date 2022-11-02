package liga.medical.person_service.api.service;

import liga.medical.person_service.dto.AddressDto;
import liga.medical.person_service.request.AddressRequest;

import java.util.List;

public interface AddressService {
    AddressDto handleThenSave(AddressRequest addressRequest);

    AddressDto handleThenUpdate(AddressRequest addressRequest);

    AddressDto getById(Long id);

    List<AddressDto> getAll();

    AddressDto save(AddressDto dto);

    AddressDto update(AddressDto dto);

    Long delete(Long id);
}

