package com.sb.formation.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Participant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private int tel;
    @ManyToOne
    private Profile profile;
    @ManyToOne
    private Pays pays;
    @ManyToOne
    private Organisme organisme;
}
