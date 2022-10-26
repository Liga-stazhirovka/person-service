package liga.medical.person_service.core.dao.entity;

import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "contact_id")
    private Long contactId;

    @NonNull
    @Column(name = "country_id")
    private Long countryId;

    @NonNull
    @Column(name = "city")
    private String city;

    @NonNull
    @Column(name = "index")
    private Integer index;

    @NonNull
    @Column(name = "street")
    private String street;

    @NonNull
    @Column(name = "building")
    private String building;

    @NonNull
    @Column(name = "flat")
    private String flat;
}
