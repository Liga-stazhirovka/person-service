package liga.medical.person_service.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"liga.medical.person_service", "liga.medical.common.service"})
public class PersonService {

    public static void main(String[] args) {
        SpringApplication.run(PersonService.class, args);
    }

}