package com.ayoub.gestiondespret.model;

import java.time.Duration;

import com.ayoub.gestiondespret.repositories.EmployeView;
import com.ayoub.gestiondespret.repositories.PretView;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Pret {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIdentityReference(alwaysAsId = true)
	@JoinColumn(name = "employe_id")
	@JsonView(PretView.Summary.class)
	private Employe employe;
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	private float montant;
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	private Duration duree;
	@JsonView({ PretView.Summary.class, EmployeView.Summary.class })
	private String staus;
}
