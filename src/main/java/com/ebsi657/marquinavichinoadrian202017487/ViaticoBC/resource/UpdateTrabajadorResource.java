package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateTrabajadorResource {
	private Long id;
	private String name;
	private String code;
	private String cargo;
	private String especialidad;
}
