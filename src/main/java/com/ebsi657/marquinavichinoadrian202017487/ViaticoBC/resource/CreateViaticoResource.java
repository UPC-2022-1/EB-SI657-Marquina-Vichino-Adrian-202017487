package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.Trabajador;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateViaticoResource {
	private Long monto;
	private Trabajador trabajador;
	private String concepto;
}
