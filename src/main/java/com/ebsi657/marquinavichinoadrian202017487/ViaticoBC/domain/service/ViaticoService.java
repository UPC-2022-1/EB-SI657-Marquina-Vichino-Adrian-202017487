package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.service;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.DemoEntity;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.Viatico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ViaticoService {
	List<Viatico> getAll();
	Page<Viatico> getAll(Pageable pageable);
	Viatico getById(Long viacticoId);
	Viatico create(Viatico viatico);
	Viatico update(Long viacticoId, Viatico request);
	ResponseEntity<?> delete(Long viacticoId);
	List<Viatico> getByTrabajador(Long trabajadorId);
}