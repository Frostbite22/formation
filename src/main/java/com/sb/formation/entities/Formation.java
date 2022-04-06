package com.sb.formation.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Formation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=40)
	private String titre;
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private EParticipant type;
	private int annee;
	private String nb_session;
	private int duree;
	private double budget;
	@ManyToOne
	private Domaine domaine;
	@OneToMany(mappedBy="formation")
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	private Collection<Session> sessions;
}
