package liga.medical.person_service.core.repository.entity.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medical_card")
public class MedicalCardEntity {
    @Id
    @Column(name = "medical_card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(name = "client_status")
    private String clientStatus;

    @NonNull
    @Column(name = "med_status")
    private String medStatus;

    @NonNull
    @Column(name = "registry_dt")
    private Date registryDate;

    @NonNull
    @Column(name = "comment")
    private String comment;
}
