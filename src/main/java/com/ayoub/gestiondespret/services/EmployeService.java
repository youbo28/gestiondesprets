package com.ayoub.gestiondespret.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayoub.gestiondespret.model.Employe;
import com.ayoub.gestiondespret.repositories.EmployeRepository;

@Service
public class EmployeService {
	@Autowired
	private EmployeRepository employeRepository;

	public List<Employe> getAllEmploye() {
		return employeRepository.findAll();
	}

	public Employe getEmployeById(Long id) {
		return employeRepository.findById(id).orElse(null);
	}

	public boolean deleteEmployeById(Long id) {
		boolean ifexist = employeRepository.existsById(id);
		if (ifexist) {
			employeRepository.deleteById(id);
		}

		return ifexist;
	}

	public Employe updateEmploye(Employe employe) {
		return employeRepository.save(null);
	}

	public void saveEmploye(Employe employe) {
		employeRepository.save(employe);
	}
}
