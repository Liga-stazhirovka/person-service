package liga.medical.person_service.core.dao.repository.entity.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import java.sql.Date;
import java.time.ZonedDateTime;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "illness")
public class IllnessEntity {

    @Id
    @Column(name = "illness_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medical_card_id")
    private MedicalCardEntity medicalCardEntity;

    @NonNull
    @Column(name = "type_id")
    private Long typeId;

    @NonNull
    @Column(name = "heaviness")
    private String heaviness;

    @NonNull
    @Column(name = "appearance_dttm")
    private ZonedDateTime appearanceDate;

    @NonNull
    @Column(name = "recovery_dt")
    private Date recoveryDate;
}
