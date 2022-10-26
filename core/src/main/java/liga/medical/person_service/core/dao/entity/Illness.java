package liga.medical.person_service.core.dao.entity;

import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
    @Column(name = "medical_card_id")
    private Long medicalCardId;

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
