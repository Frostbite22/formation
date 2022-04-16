package com.sb.formation.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Organisme {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=20)
	@NotNull
	private String libelle;
	@OneToMany(mappedBy="organisme")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Participant> participants;
	@OneToMany(mappedBy="organisme")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Formateur> formateurs;
	@OneToMany(mappedBy="organisme")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Session> sessions;
}
