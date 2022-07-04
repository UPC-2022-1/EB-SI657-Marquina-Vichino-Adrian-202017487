package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.persistence;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.Viatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViaticoRepository extends JpaRepository<Viatico, Long> {
	Optional<List<Viatico>> findByTrabajador(Long trabajadorId);
}
