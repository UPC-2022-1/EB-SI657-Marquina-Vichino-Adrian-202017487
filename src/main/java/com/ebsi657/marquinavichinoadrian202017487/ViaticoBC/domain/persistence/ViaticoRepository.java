package com.ebsi657.marquinavichinoadrian202017487.demo.domain.persistence;

import com.ebsi657.marquinavichinoadrian202017487.demo.domain.model.entity.Viatico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ViaticoRepository extends JpaRepository<Viatico, Long> {
}
