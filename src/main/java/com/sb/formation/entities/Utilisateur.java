package com.sb.formation.entities;

import java.util.Collection;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Utilisateur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	@Column(length=50)
	@NotNull
	private String login;
	@Column(length=120)
	@NotNull
	private String Password;
	@ManyToMany
	private Collection<Role> roles;

	public Utilisateur(String login, String password) {
		this.login = login;
		Password = password;
	}
}
