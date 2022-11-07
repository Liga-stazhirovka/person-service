package liga.medical.person_service.core.repository;

import liga.medical.person_service.core.repository.entity.entity.MedicalCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalCardRepository extends JpaRepository<MedicalCardEntity, Long> {
    Optional<MedicalCardEntity> findById(Long id);
}
