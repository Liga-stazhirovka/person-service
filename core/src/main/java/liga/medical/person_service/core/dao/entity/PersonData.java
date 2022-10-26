package liga.medical.person_service.core.dao.entity;

import lombok.NonNull;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "contact_id")
    private Contact contact;

    @NonNull
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "medical_card_id")
    private MedicalCard medicalCard;

    @NonNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "child_parent",
            joinColumns = @JoinColumn(name = "parent", referencedColumnName = "parent_id"),
            inverseJoinColumns = @JoinColumn(name = "child", referencedColumnName = "person_data_id")
    )
    @Column(name = "parent_id")
    private List<PersonData> parentId;
}
