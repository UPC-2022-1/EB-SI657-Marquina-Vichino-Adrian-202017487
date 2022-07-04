package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.service;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.persistence.DemoRepository;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.service.DemoService;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.DemoEntity;
import com.ebsi657.marquinavichinoadrian202017487.shared.exeption.ResourceNotFoundException;
import com.ebsi657.marquinavichinoadrian202017487.shared.exeption.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class DemoServiceImpl implements DemoService {

	private static final String ENTITY = "DemoEntity";

	private final DemoRepository demoRepository;

	private final Validator validator;

	public DemoServiceImpl(DemoRepository demoRepository, Validator validator) {
		this.demoRepository = demoRepository;
		this.validator      = validator;
	}

	@Override
	public List<DemoEntity> getAll() {
		return demoRepository.findAll();
	}

	@Override
	public Page<DemoEntity> getAll(Pageable pageable) {
		return demoRepository.findAll(pageable);
	}

	@Override
	public DemoEntity getById(Long demoId) {
		return demoRepository.findById(demoId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, demoId));
	}

	@Override
	public DemoEntity create(DemoEntity demoEntity) {
		Set<ConstraintViolation<DemoEntity>> violations = validator.validate(demoEntity);
		if (!violations.isEmpty()) throw new ResourceValidationException(ENTITY, violations);
		// Name Uniqueness validation
		DemoEntity studentWithName = demoRepository.findByName(demoEntity.getName());
		if (studentWithName != null) throw new ResourceValidationException(ENTITY,
		                                                                   "An demo entity with the same name already "
				                                                                   + "exists.");
		return demoRepository.save(demoEntity);
	}

	@Override
	public DemoEntity update(Long demoId, DemoEntity request) {
		Set<ConstraintViolation<DemoEntity>> violations = validator.validate(request);
		if (!violations.isEmpty()) throw new ResourceValidationException(ENTITY, violations);
		// Name Uniqueness validation
		DemoEntity demoWithName = demoRepository.findByName(request.getName());
		if (demoWithName != null && !demoWithName.getId().equals(demoId)) throw new ResourceValidationException(ENTITY,
		                                                                                                        "An demo entity with the same name already exists.");
		return demoRepository.findById(demoId).map(
				student -> demoRepository.save(student.withName(request.getName()))).orElseThrow(
				() -> new ResourceNotFoundException(ENTITY, demoId));
	}

	@Override
	public ResponseEntity<?> delete(Long demoId) {
		return demoRepository.findById(demoId).map(demoEntity -> {
			demoRepository.delete(demoEntity);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(ENTITY, demoId));
	}
}