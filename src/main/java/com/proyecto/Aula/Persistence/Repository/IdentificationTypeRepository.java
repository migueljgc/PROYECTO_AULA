package com.proyecto.Aula.Persistence.Repository;

import com.proyecto.Aula.Persistence.Entity.IdentificationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IdentificationTypeRepository extends JpaRepository<IdentificationType, Long> {
}
