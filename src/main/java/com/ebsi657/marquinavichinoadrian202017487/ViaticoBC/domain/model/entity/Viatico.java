package com.ebsi657.marquinavichinoadrian202017487.ViaticoBC.domain.model.entity;

import lombok.*;

import javax.persistence.*;
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
@Entity
@Table(name = "Viaticos")
public class Viatico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Min(0)
	@Column()
	private Long monto;

	@NotNull
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trabajador_id", nullable = false)
	private Trabajador trabajador;

	@NotNull
	@NotBlank
	@Size(max = 255)
	@Column()
	private String concepto;
}
