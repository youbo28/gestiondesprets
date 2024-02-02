package com.ayoub.gestiondespret.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ayoub.gestiondespret.model.Employe;
import com.ayoub.gestiondespret.repositories.EmployeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeService {
	@Autowired
	private EmployeRepository employeRepository;

	public Page<Employe> getAllEmploye(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return employeRepository.findAll(pageable);
	}

	public Employe getEmployeById(Long id) throws Exception {
		return employeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("il n'y a aucun employé avec l'id " + id));
	}

	public void deleteEmployeById(Long id) throws Exception {

		if (employeRepository.existsById(id)) {
			employeRepository.deleteById(id);
		}
		throw new EntityNotFoundException("il n'y a aucun employé avec l'id " + id);

	}

	public Employe updateEmploye(Employe employe) throws Exception {
		if (employeRepository.existsById(employe.getIdEmploye())) {
			return employeRepository.save(employe);
		}
		throw new EntityNotFoundException("il n'y a aucun employé avec l'id " + employe.getIdEmploye());

	}

	public Employe saveEmploye(Employe employe) {
		return employeRepository.save(employe);
	}
}
