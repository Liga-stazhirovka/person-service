package liga.medical.person_service.core.repository;

import liga.medical.person_service.core.repository.entity.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    Optional<RoleEntity> findById(Long id);

    Optional<RoleEntity> findByName(String nameRole);

}