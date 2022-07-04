package com.ebsi657.marquinavichinoadrian202017487.demo.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Trabajadores")
public class Trabajador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Size(max = 60)
	@Column(unique = true)
	private String name;

	@NotNull
	@NotBlank
	@Size(min = 8, max = 8)
	@Column(unique = true)
	private String codigo;

	@NotNull
	@NotBlank
	@Size(max = 60)
	@Column()
	private String cargo;

	@NotNull
	@NotBlank
	@Size(max = 60)
	@Column()
	private String especialidad;
}
