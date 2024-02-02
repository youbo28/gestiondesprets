package com.ayoub.gestiondespret.contrôleurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayoub.gestiondespret.model.Employe;
import com.ayoub.gestiondespret.modelView.EmployeView;
import com.ayoub.gestiondespret.services.EmployeService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api/employe")
public class EmployeControlleur {
	@Autowired
	private EmployeService employeService;

	// Endpoint pour récupérer tous les employés
	@JsonView(EmployeView.Summary.class)
	@GetMapping
	public ResponseEntity<Page<Employe>> getAllEmploye(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size) {

		return new ResponseEntity<>(employeService.getAllEmploye(page, size), HttpStatus.OK);

	}

	// Endpoint pour récupérer l’employé spécifié par id
	@JsonView(EmployeView.Summary.class)
	@GetMapping("/{id}")
	public ResponseEntity<Employe> respogetEmployeById(@PathVariable Long id) throws Exception {

		return new ResponseEntity<Employe>(employeService.getEmployeById(id), HttpStatus.OK);

	}

	// Endpoint pour mettre à jour un employé
	@PutMapping("/{id}")
	public ResponseEntity<Employe> updateEmploye(@PathVariable Long id, @RequestBody Employe employe) throws Exception {

		return new ResponseEntity<Employe>(employeService.updateEmploye(employe), HttpStatus.OK);
	}

	// Endpoint pour créer un nouvel employé
	@PostMapping
	public ResponseEntity<Employe> createEmploye(@jakarta.validation.Valid @RequestBody Employe employe) {
		return new ResponseEntity<Employe>(employeService.saveEmploye(employe), HttpStatus.OK);
	}

	// Endpoint pour supprimer un employé spécifique par id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmploye(@PathVariable Long id) throws Exception {
		employeService.deleteEmployeById(id);
		return new ResponseEntity<String>(HttpStatus.OK);

	}
}
