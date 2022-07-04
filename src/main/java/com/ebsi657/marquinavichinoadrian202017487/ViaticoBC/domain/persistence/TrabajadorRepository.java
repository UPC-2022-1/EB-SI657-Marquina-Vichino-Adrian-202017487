package com.ebsi657.marquinavichinoadrian202017487.demo.domain.persistence;

import com.ebsi657.marquinavichinoadrian202017487.demo.domain.model.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
	Trabajador findByName(String name);
}
