package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.service;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.Trabajador;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.Viatico;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.persistence.ViaticoRepository;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.service.TrabajadorService;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.service.ViaticoService;
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
public class ViaticoServiceImlp implements ViaticoService {

	private static final String ENTITY = "Viatico";

	private final ViaticoRepository viaticoRepository;

	private final Validator validator;

	private final TrabajadorService trabajadorService;

	public ViaticoServiceImlp(
			ViaticoRepository viaticoRepository, Validator validator, TrabajadorService trabajadorService
	) {
		this.validator         = validator;
		this.viaticoRepository = viaticoRepository;
		this.trabajadorService = trabajadorService;
	}

	@Override
	public List<Viatico> getAll() {
		return viaticoRepository.findAll();
	}

	@Override
	public Page<Viatico> getAll(Pageable pageable) {
		return viaticoRepository.findAll(pageable);
	}

	@Override
	public Viatico getById(Long viaticoId) {
		return viaticoRepository.findById(viaticoId).orElseThrow(
				() -> new ResourceNotFoundException(ENTITY, viaticoId));
	}

	@Override
	public List<Viatico> getByTrabajador(Long trabajadorId) {
		return viaticoRepository.findByTrabajador(trabajadorId).orElseThrow(
				() -> new ResourceNotFoundException(ENTITY, trabajadorId));
	}

	@Override
	public Viatico create(Viatico viatico) {
		Set<ConstraintViolation<Viatico>> violations = validator.validate(viatico);
		if (!violations.isEmpty()) throw new ResourceValidationException(ENTITY, violations);
		Optional<Trabajador> trabajador = Optional.ofNullable(
				trabajadorService.getById(viatico.getTrabajador().getId()));
		if (!trabajador.isPresent()) throw new ResourceNotFoundException(ENTITY, viatico.getTrabajador().getId());
		viatico.setTrabajador(trabajador.get());
		return viaticoRepository.save(viatico);
	}

	@Override
	public Viatico update(Long viaticoId, Viatico request) {
		log.info("======================");
		log.info(request.toString());
		Viatico viatico = getById(viaticoId);
		if (viatico == null) throw new ResourceNotFoundException(ENTITY, viaticoId);
		if (request.getTrabajador() == null) {
			Optional<Trabajador> trabajador = Optional.ofNullable(
					trabajadorService.getById(viatico.getTrabajador().getId()));
			if (!trabajador.isPresent()) throw new ResourceNotFoundException(ENTITY, viatico.getTrabajador().getId());
			request.setTrabajador(trabajador.get());
		} else {
			Optional<Trabajador> trabajador = Optional.ofNullable(
					trabajadorService.getById(request.getTrabajador().getId()));
			if (!trabajador.isPresent()) throw new ResourceNotFoundException(ENTITY, viatico.getTrabajador().getId());
			request.setTrabajador(trabajador.get());
		}
		Set<ConstraintViolation<Viatico>> violations = validator.validate(request);
		if (!violations.isEmpty()) throw new ResourceValidationException(ENTITY, violations);

		if (request.getMonto() == null) {
			request.setMonto(viatico.getMonto());
		}
		if (request.getConcepto() == null) {
			request.setConcepto(viatico.getConcepto());
		}
		log.info("======================");
		log.info(request.toString());
		return viaticoRepository.save(request);
	}

	@Override
	public ResponseEntity<?> delete(Long viaticoId) {
		return viaticoRepository.findById(viaticoId).map(viatico -> {
			viaticoRepository.delete(viatico);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException(ENTITY, viaticoId));
	}
}
