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

import com.ayoub.gestiondespret.model.Pret;
import com.ayoub.gestiondespret.modelView.PretView;
import com.ayoub.gestiondespret.services.PretService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/api/prets")

public class PretsControlleur {
	@Autowired
	private PretService pretService;

	// Endpoint pour récupérer tous les prets
	@JsonView(PretView.Summary.class)
	@GetMapping
	public ResponseEntity<Page<Pret>> getAllPret(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size) {

		return new ResponseEntity<>(pretService.getAllPrets(page, size), HttpStatus.OK);

	}

	// Endpoint pour récupérer pret spécifié par id
	@JsonView(PretView.Summary.class)
	@GetMapping("/{id}")
	public ResponseEntity<Pret> getPretByID(@PathVariable Long id) {
		return new ResponseEntity<>(pretService.getPretById(id), HttpStatus.OK);
	}

	// Endpoint pour mettre à jour un pret
	@PutMapping("/{id}")
	public ResponseEntity<Pret> updatePret(@PathVariable Long id, @RequestBody Pret pret) {
		Pret updatedPret = pretService.updatePret(pret);
		return new ResponseEntity<Pret>(updatedPret, HttpStatus.OK);
	}

	// Endpoint pour créer un nouveau prêt
	@PostMapping
	public ResponseEntity<Pret> createPret(@jakarta.validation.Valid @RequestBody Pret pret) {
		return new ResponseEntity<Pret>(pretService.createPret(pret), HttpStatus.OK);
	}

	// Endpoint pour supprimer un pret spécifique par id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePret(@PathVariable Long id) {

		pretService.deletePret(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

}
