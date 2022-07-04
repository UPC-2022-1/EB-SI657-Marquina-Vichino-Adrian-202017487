package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateTrabajadorResource {
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String code;
	@NotNull
	@NotBlank
	private String cargo;
	@NotNull
	@NotBlank
	private String especialidad;
}
