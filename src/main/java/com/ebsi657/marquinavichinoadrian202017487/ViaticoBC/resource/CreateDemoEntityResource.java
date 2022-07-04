package com.ebsi657.marquinavichinoadrian202017487.demo.resource;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateDemoEntityResource   {
	@NotNull
	@NotBlank
	@Size(max = 60)
	private String name;
}
