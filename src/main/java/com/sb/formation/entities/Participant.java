package com.sb.formation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=75)
    @NotNull
    private String nom;
    @Column(length=75)
    @NotNull
    private String prenom;
    @Column(length=50)
    @NotNull
    private String email;
    private int tel;
    @ManyToOne
    @NotNull
    private Profil profil;
    @ManyToOne
    @NotNull
    private Pays pays;
    @ManyToOne
    @NotNull
    private Organisme organisme;
}
