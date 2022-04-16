package com.sb.formation.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Domaine{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true,nullable = false)
	@NotNull
	private String libelle;
	@NotNull
	@OneToMany(mappedBy="domaine")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Formation> formations;
}