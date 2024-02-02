package com.ayoub.gestiondespret.model;

import com.ayoub.gestiondespret.modelView.EmployeView;
import com.ayoub.gestiondespret.modelView.PretView;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/*
 * Représente une entité pret
 * */

@Entity
@Data
public class Pret {
	/* id du pret */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	private Long id;

	/* Montant du prêt */
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	@javax.validation.constraints.NotNull(message = "montant ne peut pas etre null ")
	private float montant;

	/* Duree du prêt */
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	@javax.validation.constraints.NotNull(message = "duree ne peut pas etre null ")
	@NotEmpty(message = "duree ne peut pas etre vide")
	private int dureeEnMois;

	/* Statu du prêt */
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	@javax.validation.constraints.NotNull(message = "Il est impossible de laisser un statut vide")
	@NotEmpty(message = "Il est impossible de laisser un statut vide")
	private String statut;

	/* l'employé propriétaire du prêt */
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIdentityReference(alwaysAsId = true)
	@JoinColumn(name = "employe_id")
	@JsonView(PretView.Summary.class)
	@NotNull(message = "le prêt doit avoir un employé")
	private Employe employe;
}
