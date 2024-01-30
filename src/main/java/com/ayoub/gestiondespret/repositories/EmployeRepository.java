package com.ayoub.gestiondespret.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayoub.gestiondespret.model.Employe;


public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
