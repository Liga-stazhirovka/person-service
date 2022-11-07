package liga.medical.person_service.core.repository;

import liga.medical.person_service.core.repository.entity.entity.PersonDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonDataRepository extends JpaRepository<PersonDataEntity, Long> {
    Optional<PersonDataEntity> findById(Long id);
}
