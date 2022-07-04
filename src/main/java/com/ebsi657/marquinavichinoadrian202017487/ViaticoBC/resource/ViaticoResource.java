package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.resource;

import com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity.Trabajador;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ViaticoResource {
	private Long id;
	private Long monto;
	private Trabajador trabajador;
	private String concepto;
}
