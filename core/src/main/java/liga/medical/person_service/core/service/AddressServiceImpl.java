package liga.medical.person_service.core.service;

import liga.medical.person_service.api.repository.AddressRepository;
import liga.medical.person_service.api.service.AddressService;
import liga.medical.person_service.api.service.ContactService;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.dao.entity.AddressEntity;
import liga.medical.person_service.dto.AddressDto;
import liga.medical.person_service.dto.ContactDto;
import liga.medical.person_service.request.AddressRequest;
import liga.medical.person_service.utils.mapper.AddressMapper;
import liga.medical.person_service.utils.mapper.ContactMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ContactService contactService;
    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;

    @Override
    public AddressDto getById(Long id) {
        Optional<AddressEntity> optionalAddressEntity = addressRepository.findById(id);
        if (optionalAddressEntity.isEmpty())
            throw new NotFoundException("Address by Id not fount, Id: " + id);
        return addressMapper.toDto(optionalAddressEntity.get());
    }

    @Override
    public List<AddressDto> getAll() {
        return addressRepository.findAll().stream()
                .map(addressMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto save(AddressDto dto) {
        Optional<AddressEntity> optionalAddressEntity = addressRepository.findById(dto.getId());
        if (optionalAddressEntity.isPresent())
            throw new NotFoundException("Address save error, Address already exist with ID: " + dto.getId());
        addressRepository.save(addressMapper.toEntity(dto));
        return dto;
    }

    @Override
    public AddressDto handleThenSave(AddressRequest addressRequest) {
        return save(findContactAndBuildAddressDto(addressRequest));
    }

    @Override
    public AddressDto update(AddressDto dto) {
        Optional<AddressEntity> optionalAddressEntity = addressRepository.findById(dto.getId());
        if (optionalAddressEntity.isEmpty())
            throw new NotFoundException("Address update error! Address by Id not fount, Id: " + dto.getId());
        addressRepository.save(addressMapper.toEntity(dto));
        return dto;
    }

    @Override
    public AddressDto handleThenUpdate(AddressRequest addressRequest) {
        return update(findContactAndBuildAddressDto(addressRequest));
    }

    @Override
    public Long delete(Long id) {
        Optional<AddressEntity> optionalAddressEntity = addressRepository.findById(id);
        if (optionalAddressEntity.isEmpty())
            throw new NotFoundException("Address delete error! Address by Id not fount, Id: " + id);
        addressRepository.delete(optionalAddressEntity.get());
        return id;
    }

    private AddressDto findContactAndBuildAddressDto(AddressRequest request) {
        ContactDto contactDto = contactService.getById(request.getContactId());
        return AddressDto.builder()
                .contactDto(contactDto)
                .countryId(request.getCountryId())
                .city(request.getCity())
                .index(request.getIndex())
                .street(request.getStreet())
                .building(request.getBuilding())
                .flat(request.getFlat())
                .build();
    }
}
