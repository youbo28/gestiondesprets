package com.ayoub.gestiondespret.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayoub.gestiondespret.model.Pret;

@Repository
public interface PretRepository extends JpaRepository<Pret, Long>{

}
