package com.ebsi657.marquinavichinoadrian202017487.demo.mapping;

import com.ebsi657.marquinavichinoadrian202017487.demo.domain.model.entity.DemoEntity;
import com.ebsi657.marquinavichinoadrian202017487.demo.resource.DemoEntityResource;
import com.ebsi657.marquinavichinoadrian202017487.demo.resource.CreateDemoEntityResource;
import com.ebsi657.marquinavichinoadrian202017487.demo.resource.UpdateDemoEntityResource;
import com.ebsi657.marquinavichinoadrian202017487.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class DemoMapper implements Serializable {

	@Autowired
	EnhancedModelMapper mapper;

	// Object Mapping
	public DemoEntityResource toResource(DemoEntity model) {
		return mapper.map(model, DemoEntityResource.class);
	}

	public Page<DemoEntityResource> modelListPage(List<DemoEntity> modelList, Pageable pageable) {
		return new PageImpl<>(mapper.mapList(modelList, DemoEntityResource.class), pageable, modelList.size());
	}

	public DemoEntity toModel(CreateDemoEntityResource resource) {
		return mapper.map(resource, DemoEntity.class);
	}

	public DemoEntity toModel(UpdateDemoEntityResource resource) {
		return mapper.map(resource, DemoEntity.class);
	}

}
