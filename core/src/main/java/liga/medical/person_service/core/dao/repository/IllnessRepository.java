package liga.medical.person_service.core.dao.repository;

import liga.medical.person_service.core.dao.repository.entity.entity.IllnessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IllnessRepository extends JpaRepository<IllnessEntity, Long> {
    Optional<IllnessEntity> findById(Long id);
}
