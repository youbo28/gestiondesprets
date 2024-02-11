package com.ayoub.gestiondespret.contrôleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	public ResponseEntity<List<Pret>> getAllPret(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "10") Integer size) {

		return new ResponseEntity<List<Pret>>(pretService.getAllPrets(page, size).getContent(), HttpStatus.OK);

	}

	// Endpoint pour récupérer pret spécifié par id
	@JsonView(PretView.Summary.class)
	@GetMapping("/{id}")
	public ResponseEntity<Pret> getPretByID(@PathVariable Long id) {
		return new ResponseEntity<>(pretService.getPretById(id), HttpStatus.OK);
	}

	// Endpoint pour mettre à jour un pret
	@JsonView(PretView.Summary.class)
	@PutMapping("/{id}")
	public ResponseEntity<Pret> updatePret(@PathVariable Long id, @jakarta.validation.Valid @RequestBody Pret pret) {
		Pret updatedPret = pretService.updatePret(pret);
		return new ResponseEntity<Pret>(updatedPret, HttpStatus.OK);
	}

	// Endpoint pour créer un nouveau prêt

	@PostMapping
	@JsonView(PretView.Summary.class)
	public ResponseEntity<Pret> createPret(@jakarta.validation.Valid @RequestBody Pret pret) {
		return new ResponseEntity<Pret>(pretService.createPret(pret), HttpStatus.OK);
	}

	// Endpoint pour supprimer un pret spécifique par id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePret(@PathVariable Long id) {

		pretService.deletePret(id);
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@GetMapping("/search")
	@JsonView(PretView.Summary.class)
	public ResponseEntity<List<Pret>> searchByStatut(@RequestParam String statut,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<List<Pret>>(pretService.searchPretByStatut(statut, pageable).getContent(),
				HttpStatus.OK);
	}

	@GetMapping("/searchByEmploye")
	@JsonView(PretView.Summary.class)
	public ResponseEntity<List<Pret>> searchByEmployeNom(@RequestParam String nomemploye,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return new ResponseEntity<List<Pret>>(pretService.searchPretByEmploye(nomemploye, pageable).getContent(),
				HttpStatus.OK);
	}
}
