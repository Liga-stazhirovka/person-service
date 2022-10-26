package liga.medical.person_service.core.dao.entity;

import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @Column(name = "contact_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "profile_link")
    private String profileLink;
}
