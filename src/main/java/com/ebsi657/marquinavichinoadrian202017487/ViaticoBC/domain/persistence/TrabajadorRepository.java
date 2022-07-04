package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.persistence;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
	Optional<Trabajador> findByName(String name);
	Optional<Trabajador> findByCode(String code);
}
