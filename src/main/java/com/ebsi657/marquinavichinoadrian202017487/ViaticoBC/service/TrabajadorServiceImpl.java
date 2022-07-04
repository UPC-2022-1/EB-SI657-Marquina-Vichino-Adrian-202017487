package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.service;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.Trabajador;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.persistence.TrabajadorRepository;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.service.TrabajadorService;
import com.ebsi657.marquinavichinoadrian202017487.shared.exeption.ResourceNotFoundException;
import com.ebsi657.marquinavichinoadrian202017487.shared.exeption.ResourceValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class TrabajadorServiceImpl implements TrabajadorService {

	private static final String ENTITY = "Trabajador";

	private final TrabajadorRepository trabajadorRepository;

	private final Validator validator;

	public TrabajadorServiceImpl(TrabajadorRepository trabajadorRepository, Validator validator) {
		this.trabajadorRepository = trabajadorRepository;
		this.validator            = validator;
	}

	@Override
	public List<Trabajador> getAll() {
		return trabajadorRepository.findAll();
	}

	@Override
	public Page<Trabajador> getAll(Pageable pageable) {
		return trabajadorRepository.findAll(pageable);
	}

	@Override
	public Trabajador getById(Long trabajadorId) {
		return trabajadorRepository.findById(trabajadorId).orElseThrow(
				() -> new ResourceNotFoundException(ENTITY, trabajadorId));
	}

	@Override
	public Trabajador getByCode(String code) {
		return trabajadorRepository.findByCode(code).orElseThrow(
				() -> new ResourceNotFoundException(ENTITY + " with code " + code));
	}

	@Override
	public Trabajador getByName(String name) {
		return trabajadorRepository.findByName(name).orElseThrow(
				() -> new ResourceNotFoundException(ENTITY + " with name " + name));
	}

	@Override
	public Trabajador create(Trabajador trabajador) {
		log.info("======================================");
		log.info("Creating " + trabajador.toString());
		Set<ConstraintViolation<Trabajador>> violations = validator.validate(trabajador);
		if (!violations.isEmpty()) throw new ResourceValidationException(ENTITY, violations);
		// Name Uniqueness validation
		Optional<Trabajador> trabajadortWithName = trabajadorRepository.findByName(trabajador.getName());
		if (trabajadortWithName.isPresent()) throw new ResourceValidationException(ENTITY,
		                                                                           "Un trabajador con el mismo nombre "
				                                                                           + "ya existe.");
		Optional<Trabajador> trabajadorWithCode = trabajadorRepository.findByCode(trabajador.getCode());
		if (trabajadorWithCode.isPresent())
			throw new ResourceValidationException(ENTITY, "Un trabajador con el mismo codigo ya existe.");
		return trabajadorRepository.save(trabajador);
	}

	@Override
	public Trabajador update(Long trabajadorId, Trabajador request) {
		Optional<Trabajador> trabajadorWithId = trabajadorRepository.findById(trabajadorId);
		if(trabajadorWithId.isEmpty()) throw new ResourceNotFoundException(ENTITY, trabajadorId);
		if(request.getName() == null) {
			request.setName(trabajadorWithId.get().getName());
		}
		if(request.getCode() == null) {
			request.setCode(trabajadorWithId.get().getCode());
		}
		if(request.getCargo() == null) {
			request.setCargo(trabajadorWithId.get().getCargo());
		}
		if(request.getEspecialidad() == null) {
			request.setEspecialidad(trabajadorWithId.get().getEspecialidad());
		}
		Set<ConstraintViolation<Trabajador>> violations = validator.validate(request);
		if (!violations.isEmpty()) throw new ResourceValidationException(ENTITY, violations);
		// Name Uniqueness validation
		Optional<Trabajador> trabajadorWithName = trabajadorRepository.findByName(request.getName());
		if (trabajadorWithName.isPresent() && !trabajadorWithName.get().getId().equals(trabajadorId))
			throw new ResourceValidationException(ENTITY, "Un trabajador con el mismo nombre existe.");
		Optional<Trabajador> trabajadorWithCode = trabajadorRepository.findByCode(request.getCode());
		if (trabajadorWithCode.isPresent() && !trabajadorWithCode.get().getId().equals(trabajadorId))
			throw new ResourceValidationException(ENTITY, "Un trabajador con el mismo codigo existe.");
		return trabajadorRepository.findById(trabajadorId).map(
				trabajadort -> trabajadorRepository.save(trabajadort.withName(request.getName()))).orElseThrow(
				() -> new ResourceNotFoundException(ENTITY, trabajadorId));
	}

	@Override
	public ResponseEntity<?> delete(Long trabajadorId) {
		return trabajadorRepository.findById(trabajadorId).map(trabajador -> {
			trabajadorRepository.delete(trabajador);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(ENTITY, trabajadorId));
	}
}
