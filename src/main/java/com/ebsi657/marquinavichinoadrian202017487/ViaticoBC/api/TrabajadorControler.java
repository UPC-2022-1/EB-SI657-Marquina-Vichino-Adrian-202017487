package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.api;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.service.DemoService;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.service.TrabajadorService;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.mapping.DemoMapper;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.mapping.TrabajadorMapper;
import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource.*;
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


@Slf4j
@Tag(name = "Trabajador")
@RestController
@RequestMapping("/trabajador")
public class TrabajadorControler {
	private final TrabajadorService trabajadorService;
	private final TrabajadorMapper  mapper;

	public TrabajadorControler(TrabajadorService trabajadorService, TrabajadorMapper mapper) {
		this.trabajadorService = trabajadorService;
		this.mapper = mapper;
	}

	@Operation(summary = "Get trabajador", description = "Obtener todos los trabajadores.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Trabajador encontrado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = TrabajadorResource.class))})
	})
	@GetMapping
	public Page<TrabajadorResource> getAllTrabajador(Pageable pageable) {
		return mapper.modelListPage(trabajadorService.getAll(), pageable);
	}

	@Operation(summary = "Get trabajador By Id", description = "Obtener un trabajador por ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Trabajador encontrado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = TrabajadorResource.class))})
	})
	@GetMapping("{trabajadorId}")
	public TrabajadorResource getTrabajadorById(@PathVariable Long trabajadorId) {
		return mapper.toResource(trabajadorService.getById(trabajadorId));
	}

	@Operation(summary = "Get trabajador By Name", description = "Obtener un trabajador por nombre.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Trabajador encontrado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = TrabajadorResource.class))})
	})
	@GetMapping("name/{name}")
	public TrabajadorResource getTrabajadorByName(@PathVariable String name) {
		return mapper.toResource(trabajadorService.getByName(name));
	}

	@Operation(summary = "Get trabajador By Code", description = "Obtener un trabajador por codigo.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Trabajador encontrado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = TrabajadorResource.class))})
	})
	@GetMapping("code/{code}")
	public TrabajadorResource getTrabajadorByCode(@PathVariable String code) {
		return mapper.toResource(trabajadorService.getByCode(code));
	}


	@Operation(summary = "Create trabajador", description = "Crea un trabajador.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Trabajador creado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = TrabajadorResource.class))})
	})
	@PostMapping
	public TrabajadorResource createDemoEntity(@RequestBody CreateTrabajadorResource resource) {
		return mapper.toResource(trabajadorService.create(mapper.toModel(resource)));
	}


	@Operation(summary = "Update trabajador", description = "Actualiza un trabajador.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Trabajador actualizado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = TrabajadorResource.class))})
	})
	@PutMapping("{trabajadorId}")
	public TrabajadorResource updateTrabajador(@PathVariable Long trabajadorId, @RequestBody UpdateTrabajadorResource resource) {
		return mapper.toResource(trabajadorService.update(trabajadorId, mapper.toModel(resource)));
	}

	@Operation(summary = "Delete trabajador", description = "Elimina un trabajador.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Trabajador eliminado",
					content = { @Content(mediaType = "application/json",
							schema = @Schema(implementation = TrabajadorResource.class))})
	})
	@DeleteMapping("{trabajadorId}")
	public ResponseEntity<?> deleteTrabajador(@PathVariable Long trabajadorId) {
		return trabajadorService.delete(trabajadorId);
	}
}
