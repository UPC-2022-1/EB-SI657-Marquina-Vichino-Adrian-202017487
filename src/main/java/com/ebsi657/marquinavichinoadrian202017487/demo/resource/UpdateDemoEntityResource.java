package com.ebsi657.marquinavichinoadrian202017487.demo.resource;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateDemoEntityResource {
	private Long id;

	@NotNull
	@NotBlank
	@Size(max = 60)
	private String name;
}
