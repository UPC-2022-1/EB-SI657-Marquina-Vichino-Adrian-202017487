package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.Trabajador;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateViaticoResource {
	private Long id;
	private Long monto;
	private Trabajador trabajador;
	private String concepto;
}
