package com.sb.formation.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Formateur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=75)
	private String nom;
	@Column(length=75)
	private String prenom;
	@Column(length=50)
	private String email;
	private int tel;
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private EFormateur type;
	@ManyToOne
	private Organisme organisme;
	@OneToMany(mappedBy="formateur")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Session> sessions;
}
