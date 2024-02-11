package com.ayoub.gestiondespret.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayoub.gestiondespret.model.Pret;

@Repository
public interface PretRepository extends JpaRepository<Pret, Long> {
	Page<Pret> findByStatut(String statut, Pageable pageable);

	Page<Pret> findByEmployeNomContainingIgnoreCase(String employeNom, Pageable pageable);

}
