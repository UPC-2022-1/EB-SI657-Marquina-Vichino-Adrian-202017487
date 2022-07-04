package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class TrabajadorResource {
	private Long id;
	private String name;
	private String code;
	private String cargo;
	private String especialidad;
}
