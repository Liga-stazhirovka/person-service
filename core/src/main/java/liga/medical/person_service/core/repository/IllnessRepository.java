package liga.medical.person_service.core.repository;

import liga.medical.person_service.core.repository.entity.entity.IllnessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IllnessRepository extends JpaRepository<IllnessEntity, Long> {
    Optional<IllnessEntity> findById(Long id);
}
