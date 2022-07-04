package com.ebsi657.marquinavichinoadrian202017487.demo.domain.service;

import com.ebsi657.marquinavichinoadrian202017487.demo.domain.model.entity.Trabajador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TrabajadorService {
	List<Trabajador> getAll();

	Page<Trabajador> getAll(Pageable pageable);

	Trabajador getById(Long trabajadorId);

	Trabajador create(Trabajador trabajador);

	Trabajador update(Long trabajadorId, Trabajador request);

	ResponseEntity<?> delete(Long trabajadorId);
}
