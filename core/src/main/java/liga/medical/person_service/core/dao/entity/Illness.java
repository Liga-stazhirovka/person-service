package liga.medical.person_service.core.dao.entity;

import lombok.NonNull;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "illness")
public class Illness {

    @Id
    @Column(name = "illness_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    @Column(name = "medical_card_id")
    private MedicalCard medicalCard;

    @NonNull
    @Column(name = "type_id")
    private Long typeId;

    @NonNull
    @Column(name = "heaviness")
    private String heaviness;

    @NonNull
    @Column(name = "appearance dttm")
    private Timestamp appearanceDate;

    @NonNull
    @Column(name = "recovery_dt")
    private Date recoveryDate;
}
