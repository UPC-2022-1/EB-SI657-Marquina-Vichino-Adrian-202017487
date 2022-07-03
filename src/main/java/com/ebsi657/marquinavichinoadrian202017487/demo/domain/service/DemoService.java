package com.ebsi657.marquinavichinoadrian202017487.demo.domain.service;

import com.ebsi657.marquinavichinoadrian202017487.demo.domain.model.entity.DemoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DemoService {
	List<DemoEntity> getAll();
	Page<DemoEntity> getAll(Pageable pageable);
	DemoEntity getById(Long demoId);
	DemoEntity create(DemoEntity demoEntity);
	DemoEntity update(Long studentId, DemoEntity request);
	ResponseEntity<?> delete(Long demoId);
}