package com.ayoub.gestiondespret.model;

import java.util.List;

import com.ayoub.gestiondespret.repositories.EmployeView;
import com.ayoub.gestiondespret.repositories.PretView;
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
import lombok.Data;

@Entity
@Data
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })

	private Long idEmploye;
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	private String nomComplet;
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	private String post;
	@JsonView(EmployeView.Summary.class)
	private float salaire;
	@JsonView(EmployeView.Summary.class)
	@OneToMany(mappedBy = "employe", cascade = CascadeType.ALL)
	private List<Pret> prets;

}
