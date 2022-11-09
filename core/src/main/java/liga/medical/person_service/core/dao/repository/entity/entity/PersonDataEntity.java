package liga.medical.person_service.core.dao.repository.entity.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person_data")
public class PersonDataEntity {

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
    @JoinColumn(name = "contact_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private ContactEntity contactEntity;

    @NonNull
    @JoinColumn(name = "medical_card_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private MedicalCardEntity medicalCardEntity;

    @NonNull
    @JoinColumn(name = "parent_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private PersonDataEntity parent;

}
