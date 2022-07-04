package com.ebsi657.marquinavichinoadrian202017487.demo.api;

import com.ebsi657.marquinavichinoadrian202017487.demo.domain.service.DemoService;
import com.ebsi657.marquinavichinoadrian202017487.demo.mapping.DemoMapper;
import com.ebsi657.marquinavichinoadrian202017487.demo.resource.CreateDemoEntityResource;
import com.ebsi657.marquinavichinoadrian202017487.demo.resource.DemoEntityResource;
import com.ebsi657.marquinavichinoadrian202017487.demo.resource.UpdateDemoEntityResource;
import org.springframework.web.bind.annotation.RequestMapping;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Demo")
@RestController
@RequestMapping("/demo")
public class DemoController {
	private final DemoService demoservice;
	private final DemoMapper  mapper;

	public DemoController(DemoService demoservice, DemoMapper mapper) {
		this.demoservice = demoservice;
		this.mapper = mapper;
	}

	@Operation(summary = "Get demo_entities", description = "Get All demo entities.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Demo Entities found",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = DemoEntityResource.class))})
	})
	@GetMapping
	public Page<DemoEntityResource> getAllDemoEntities(Pageable pageable) {
		return mapper.modelListPage(demoservice.getAll(), pageable);
	}

	@GetMapping("{demoId}")
	public DemoEntityResource getDemoEntitytById(@PathVariable Long demoId) {
		return mapper.toResource(demoservice.getById(demoId));
	}

	@PostMapping
	public DemoEntityResource createDemoEntity(@RequestBody CreateDemoEntityResource resource) {
		return mapper.toResource(demoservice.create(mapper.toModel(resource)));
	}

	@PutMapping("{demoId}")
	public DemoEntityResource updateDemoEntity(@PathVariable Long demoId, @RequestBody UpdateDemoEntityResource resource) {
		return mapper.toResource(demoservice.update(demoId, mapper.toModel(resource)));
	}

	@DeleteMapping("{demoId}")
	public ResponseEntity<?> deleteDemoEntity(@PathVariable Long demoId) {
		return demoservice.delete(demoId);
	}
}
