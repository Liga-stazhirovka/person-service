package liga.medical.person_service.core.service;

import liga.medical.person_service.core.domain.Address;
import liga.medical.person_service.core.exceptions.NotFoundException;
import liga.medical.person_service.core.mapper.AddressMapper;
import liga.medical.person_service.core.repository.AddressRepository;
import liga.medical.person_service.core.repository.entity.entity.AddressEntity;
import liga.medical.person_service.core.service.api.AddressService;
import liga.medical.person_service.core.service.api.ContactService;
import liga.medical.person_service.core.service.dto.AddressDto;
import liga.medical.person_service.core.service.dto.ContactDto;
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
    public AddressDto save(Address address) {
        return addressMapper.toDto(addressRepository.save(addressMapper.toEntity(findContactAndBuildAddressDtoForSave(address))));
    }

    @Override
    public AddressDto update(Address address) {
        Optional<AddressEntity> optionalAddressEntity = addressRepository.findById(address.getId());
        if (optionalAddressEntity.isEmpty())
            throw new NotFoundException("Address update error! Address by Id not fount, Id: " + address.getId());
        return addressMapper.toDto(addressRepository.save(addressMapper.toEntity(findContactAndBuildAddressDtoForUpdate(address))));
    }

    @Override
    public Long delete(Long id) {
        Optional<AddressEntity> optionalAddressEntity = addressRepository.findById(id);
        if (optionalAddressEntity.isEmpty())
            throw new NotFoundException("Address delete error! Address by Id not fount, Id: " + id);
        addressRepository.delete(optionalAddressEntity.get());
        return id;
    }

    private AddressDto findContactAndBuildAddressDtoForUpdate(Address address) {
        ContactDto contactDto = contactService.getById(address.getContactId());
        return AddressDto.builder()
                .id(address.getId())
                .contactDto(contactDto)
                .countryId(address.getCountryId())
                .city(address.getCity())
                .index(address.getIndex())
                .street(address.getStreet())
                .building(address.getBuilding())
                .flat(address.getFlat())
                .build();
    }

    private AddressDto findContactAndBuildAddressDtoForSave(Address address) {
        ContactDto contactDto = contactService.getById(address.getContactId());
        return AddressDto.builder()
                .contactDto(contactDto)
                .countryId(address.getCountryId())
                .city(address.getCity())
                .index(address.getIndex())
                .street(address.getStreet())
                .building(address.getBuilding())
                .flat(address.getFlat())
                .build();
    }
}
