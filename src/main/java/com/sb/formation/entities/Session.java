package com.sb.formation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String lieu;
	@NotNull
	private Date date_debut;
	@NotNull
	private Date date_fin;
	@NotNull
	private int nb_participant;
	@ManyToOne
	@NotNull
	private Formateur formateur;
	@ManyToOne
	@NotNull
	private Formation formation;
	@ManyToOne
	@NotNull
	private Organisme organisme;
	@ManyToMany
	private Collection<Participant> participants;
}
