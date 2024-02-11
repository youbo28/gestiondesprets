package com.ayoub.gestiondespret.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ayoub.gestiondespret.model.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
	Page<Employe> findBynomContainingIgnoreCase(String nom, Pageable pageable);

	//Page<Employe> findBynomComplet(String nomComplet, Pageable pageable);
}
