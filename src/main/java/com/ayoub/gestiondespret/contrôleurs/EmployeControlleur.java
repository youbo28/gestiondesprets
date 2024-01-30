package com.ayoub.gestiondespret.contrôleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayoub.gestiondespret.model.Employe;
import com.ayoub.gestiondespret.model.Pret;
import com.ayoub.gestiondespret.repositories.EmployeView;
import com.ayoub.gestiondespret.repositories.PretView;
import com.ayoub.gestiondespret.services.EmployeService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api/employe")
public class EmployeControlleur {
	@Autowired
	private EmployeService employeService;

	@JsonView(EmployeView.Summary.class)
	@GetMapping
	public List<Employe> getAllEmploye() {
		return employeService.getAllEmploye();
	}

	@JsonView(EmployeView.Summary.class)
	@GetMapping("/{id}")
	public Employe getEmployeById(@PathVariable Long id) {
		return employeService.getEmployeById(id);
	}

	@PutMapping("/{id}")
	public boolean updateEmploye(@PathVariable Long id, @RequestBody Employe employe) {
		Employe updatedEmploye = employeService.updateEmploye(employe);
		if (updatedEmploye != null) {
			return true;
		} else {
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deleteEmploye(@PathVariable Long id) {

		return employeService.deleteEmployeById(id);

	}
}
