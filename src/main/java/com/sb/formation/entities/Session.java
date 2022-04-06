package com.sb.formation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Session {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String lieu;
	private Date date_debut;
	private Date date_fin;
	private int nb_participant;
	@ManyToOne
	private Formateur formateur;
	@ManyToOne
	private Formation formation;
	@ManyToOne
	private Organisme organisme;
	@ManyToMany
	private Collection<Participant> participants;
}
