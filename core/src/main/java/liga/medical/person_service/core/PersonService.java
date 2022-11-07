package liga.medical.person_service.core;

import liga.medical.person_service.core.controller.AddressController;
import liga.medical.person_service.core.controller.IllnessController;
import liga.medical.person_service.core.controller.PersonDataController;
import liga.medical.person_service.core.controller.model.request.AddressRequestForSave;
import liga.medical.person_service.core.mapper.*;
import liga.medical.person_service.core.repository.*;
import liga.medical.person_service.core.service.AddressServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Set;

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