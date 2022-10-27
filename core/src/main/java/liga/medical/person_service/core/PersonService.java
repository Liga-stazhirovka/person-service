package liga.medical.person_service.core;

import liga.medical.person_service.api.repository.*;
import liga.medical.person_service.core.service.*;
import liga.medical.person_service.utils.mapper.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@RequiredArgsConstructor
@SpringBootApplication
@EnableJpaRepositories("liga.medical.person_service.api.repository")
@EntityScan("liga.medical.person_service.dao.entity")
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

    private final AddressMapper addressMapper;
    private final ContactMapper contactMapper;
    private final IllnessMapper illnessMapper;
    private final MedicalCardMapper medicalCardMapper;
    private final PersonDataMapper personDataMapper;


    @Override
    public void run(String... args) throws Exception {
        AddressServiceImpl addressService = new AddressServiceImpl(addressRepository,addressMapper);
        ContactServiceImpl contactService = new ContactServiceImpl(contactRepository,contactMapper);
        IllnessServiceImpl illnessService = new IllnessServiceImpl(illnessRepository,illnessMapper);
        MedicalCardServiceImpl medicalCardService = new MedicalCardServiceImpl(medicalCardRepository,medicalCardMapper);
        PersonDataServiceImpl personDataService = new PersonDataServiceImpl(personDataRepository,personDataMapper);

        System.out.println(addressService.getById(1L));
        System.out.println(contactService.getById(1L));
        System.out.println(illnessService.getById(1L));
        System.out.println(medicalCardService.getById(1L));
        System.out.println(personDataService.getById(1L));
    }
}