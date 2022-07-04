package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.api;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.Viatico;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.service.ViaticoService;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.mapping.ViaticoMapper;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource.CreateViaticoResource;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource.ViaticoResource;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource.UpdateViaticoResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Tag(name = "Viatico")
@RestController
@RequestMapping("/viatico")
public class ViaticoController {
	private final ViaticoService viaticoService;
	private final ViaticoMapper  mapper;

	public ViaticoController(ViaticoService viaticoService, ViaticoMapper mapper) {
		this.viaticoService = viaticoService;
		this.mapper = mapper;
	}

	@Operation(summary = "Get viatico", description = "Obtener todos los viaticoes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Viatico encontrado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = ViaticoResource.class))})
	})
	@GetMapping
	public Page<ViaticoResource> getAllViatico(Pageable pageable) {
		return mapper.modelListPage(viaticoService.getAll(), pageable);
	}

	@Operation(summary = "Get viatico By Id", description = "Obtener un viatico por ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Viatico encontrado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = ViaticoResource.class))})
	})
	@GetMapping("{viaticoId}")
	public ViaticoResource getViaticoById(@PathVariable Long viaticoId) {
		return mapper.toResource(viaticoService.getById(viaticoId));
	}

	@Operation(summary = "Get viatico By Name", description = "Obtener un viatico por nombre.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Viatico encontrado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = ViaticoResource.class))})
	})
	@GetMapping("trabajador/{trabajadorId}")
	public List<ViaticoResource> getViaticoByName(@PathVariable Long trabajadorId) {
		List<Viatico> viaticos = viaticoService.getByTrabajador(trabajadorId);
		List<ViaticoResource> viaticoResources = new ArrayList<>();
		for (Viatico viatico : viaticos) {
			viaticoResources.add(mapper.toResource(viatico));
		}
		return viaticoResources;
	}


	@Operation(summary = "Create viatico", description = "Crea un viatico.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Viatico creado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = ViaticoResource.class))})
	})
	@PostMapping
	public ViaticoResource createDemoEntity(@RequestBody CreateViaticoResource resource) {
		return mapper.toResource(viaticoService.create(mapper.toModel(resource)));
	}


	@Operation(summary = "Update viatico", description = "Actualiza un viatico.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Viatico actualizado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = ViaticoResource.class))})
	})
	@PutMapping("{viaticoId}")
	public ViaticoResource updateViatico(@PathVariable Long viaticoId, @RequestBody UpdateViaticoResource resource) {
		return mapper.toResource(viaticoService.update(viaticoId, mapper.toModel(resource)));
	}

	@Operation(summary = "Delete viatico", description = "Elimina un viatico.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Viatico eliminado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = ViaticoResource.class))})
	})
	@DeleteMapping("{viaticoId}")
	public ResponseEntity<?> deleteViatico(@PathVariable Long viaticoId) {
		return viaticoService.delete(viaticoId);
	}
}
