package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.persistence;

import java.util.List;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Long> {
	List<DemoEntity> findAll();
	DemoEntity findByName(String name);
}