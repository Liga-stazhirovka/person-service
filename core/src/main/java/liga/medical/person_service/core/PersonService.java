package liga.medical.person_service.core;

import liga.medical.person_service.core.dao.repository.AddressRepository;
import liga.medical.person_service.core.dao.repository.ContactRepository;
import liga.medical.person_service.core.dao.repository.IllnessRepository;
import liga.medical.person_service.core.dao.repository.MedicalCardRepository;
import liga.medical.person_service.core.dao.repository.PersonDataRepository;
import liga.medical.person_service.core.dao.repository.RoleRepository;
import liga.medical.person_service.core.dao.repository.UserRepository;
import liga.medical.person_service.core.mapper.AddressMapper;
import liga.medical.person_service.core.mapper.ContactMapper;
import liga.medical.person_service.core.mapper.IllnessMapper;
import liga.medical.person_service.core.mapper.MedicalCardMapper;
import liga.medical.person_service.core.mapper.PersonDataMapper;
import liga.medical.person_service.core.service.AddressServiceImpl;
import liga.medical.person_service.core.view.rest.controller.AddressController;
import liga.medical.person_service.core.view.rest.controller.IllnessController;
import liga.medical.person_service.core.view.rest.controller.PersonDataController;
import liga.medical.person_service.core.view.rest.controller.model.request.AddressRequestForSave;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EnableJpaRepositories("liga.medical.person_service.api.repository")
//@EntityScan("liga.medical.person_service.dao.entity")
@SpringBootApplication
@RequiredArgsConstructor
@ComponentScan(basePackages = {"liga.medical.person_service", "liga.medical.common.service"})
public class PersonService implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(PersonService.class, args);
    }

    private final AddressRepository addressRepository;
    private final ContactRepository contactRepository;
    private final IllnessRepository illnessRepository;
    private final MedicalCardRepository medicalCardRepository;
    private final PersonDataRepository personDataRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;
    private final IllnessMapper illnessMapper;
    private final MedicalCardMapper medicalCardMapper;
    private final PersonDataMapper personDataMapper;

    private final AddressController addressController;
    private final IllnessController illnessController;
    private final PersonDataController personDataController;

    private final AddressServiceImpl addressService;


    @Override
    public void run(String... args) throws Exception {
        addressController.add(new AddressRequestForSave(1L,555L,"555",555,"555","555","555"));
    }
}