package liga.medical.person_service.core.dao.entity;

import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;

@Entity
@Table(name = "person_data")
public class PersonData {

    @Id
    @Column(name = "person_data_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "birth_dt")
    private Date birthDay;

    @NonNull
    @Column(name = "age")
    private Byte age;

    @NonNull
    @Column(name = "sex")
    private String sex;

    @NonNull
    @Column(name = "contact_id")
    private Long contactId;

    @NonNull
    @Column(name = "medical_card_id")
    private Long medicalCardId;

    @NonNull
    @Column(name = "parent_id")
    private Long parentId;
}
