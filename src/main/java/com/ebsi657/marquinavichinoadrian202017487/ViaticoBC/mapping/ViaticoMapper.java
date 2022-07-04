package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.mapping;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.Viatico;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource.CreateViaticoResource;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource.ViaticoResource;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource.UpdateViaticoResource;
import com.ebsi657.marquinavichinoadrian202017487.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ViaticoMapper implements Serializable {
	@Autowired
	EnhancedModelMapper mapper;

	// Object Mapping
	public ViaticoResource toResource(Viatico model) {
		return mapper.map(model, ViaticoResource.class);
	}

	public Page<ViaticoResource> modelListPage(List<Viatico> modelList, Pageable pageable) {
		return new PageImpl<>(mapper.mapList(modelList, ViaticoResource.class), pageable, modelList.size());
	}

	public Viatico toModel(CreateViaticoResource resource) {
		return mapper.map(resource, Viatico.class);
	}

	public Viatico toModel(UpdateViaticoResource resource) {
		return mapper.map(resource, Viatico.class);
	}
}
