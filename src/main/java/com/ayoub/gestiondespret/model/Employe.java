package com.ayoub.gestiondespret.model;

import java.util.List;

import com.ayoub.gestiondespret.costumAnnotations.ValidateNomDEmploye;
import com.ayoub.gestiondespret.modelView.EmployeView;
import com.ayoub.gestiondespret.modelView.PretView;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

/*
 * Représente une entité employé
 * */
@Entity
@Data

public class Employe {

	/* Id de l'employe */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	private Long idEmploye;

	/* Nom Complet de l'employe */
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	@ValidateNomDEmploye(message = "champ nom de l'employé ne peut pas être nul ou contenir des chiffres")
	@jakarta.validation.constraints.NotEmpty
	@NotNull
	private String nom;

	/* Post de l'employe */
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	@javax.validation.constraints.NotNull(message = "Le poste de l'employé ne peut pas être nul")
	@NotEmpty(message = "Le poste de l'employé ne peut pas être vide")
	private String post;

	/* Salaire de l'employe */
	@JsonView(EmployeView.Summary.class)
	@NotNull(message = "Le salaire de l'employé ne peut pas être vide")
	@Positive(message = "Le salaire de l'employé ne peut pas être zero ou negative")
	private float salaire;

	/* list des prets de l'employe */
	@JsonView(EmployeView.Summary.class)
	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
	//@JsonIgnore
	private List<Pret> prets;

}
