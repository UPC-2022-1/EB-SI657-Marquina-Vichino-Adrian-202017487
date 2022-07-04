package com.ebsi657.marquinavichinoadrian202017487.demo.mapping;

import com.ebsi657.marquinavichinoadrian202017487.demo.domain.model.entity.Trabajador;
import com.ebsi657.marquinavichinoadrian202017487.demo.domain.model.entity.Trabajador;
import com.ebsi657.marquinavichinoadrian202017487.demo.resource.CreateTrabajadorResource;
import com.ebsi657.marquinavichinoadrian202017487.demo.resource.TrabajadorResource;
import com.ebsi657.marquinavichinoadrian202017487.demo.resource.UpdateTrabajadorResource;
import com.ebsi657.marquinavichinoadrian202017487.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class TrabajadorMapper implements Serializable {
	@Autowired
	EnhancedModelMapper mapper;

	// Object Mapping
	public TrabajadorResource toResource(Trabajador model) {
		return mapper.map(model, TrabajadorResource.class);
	}

	public Page<TrabajadorResource> modelListPage(List<Trabajador> modelList, Pageable pageable) {
		return new PageImpl<>(mapper.mapList(modelList, TrabajadorResource.class), pageable, modelList.size());
	}

	public Trabajador toModel(CreateTrabajadorResource resource) {
		return mapper.map(resource, Trabajador.class);
	}

	public Trabajador toModel(UpdateTrabajadorResource resource) {
		return mapper.map(resource, Trabajador.class);
	}
}
