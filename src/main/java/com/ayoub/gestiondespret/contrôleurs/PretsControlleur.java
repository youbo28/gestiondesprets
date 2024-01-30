package com.ayoub.gestiondespret.contrôleurs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayoub.gestiondespret.model.Pret;
import com.ayoub.gestiondespret.repositories.EmployeView;
import com.ayoub.gestiondespret.repositories.PretView;
import com.ayoub.gestiondespret.services.PretService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api/prets")

public class PretsControlleur {
	@Autowired
	private PretService pretService;

	@JsonView(PretView.Summary.class)
	@GetMapping
	public List<Pret> getAllPret() {
		System.out.println(pretService.getAllPrets().size());
		return pretService.getAllPrets();
	}

	@JsonView(PretView.Summary.class)
	@GetMapping("/{id}")
	public Pret getPretByID(@PathVariable Long id) {
		return pretService.getPretById(id);
	}

	@PutMapping("/{id}")
	public boolean updatePret(@PathVariable Long id, @RequestBody Pret pret) {
		Pret updatedPret = pretService.updatePret(pret);
		if (updatedPret != null) {
			return true;
		} else {
			return false;
		}
	}

	@DeleteMapping("/{id}")
	public boolean deletePret(@PathVariable Long id) {

		return pretService.deletePret(id);

	}

}
