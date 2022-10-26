package liga.medical.person_service.core.dao.entity;

import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    @Column(name = "contact_id")
    private Contact contact;

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
