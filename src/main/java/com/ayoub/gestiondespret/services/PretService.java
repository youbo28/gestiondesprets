package com.ayoub.gestiondespret.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ayoub.gestiondespret.model.Pret;
import com.ayoub.gestiondespret.repositories.PretRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PretService {
	@Autowired
	private PretRepository pretRepository;

	public Page<Pret> getAllPrets(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return pretRepository.findAll(pageable);
	}

	public Pret getPretById(Long id) {
		return pretRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("il n’y a pas de prêt avec l'ID " + id));
	}

	public void deletePret(Long id) {

		if (pretRepository.existsById(id)) {

			pretRepository.deleteById(id);

		} else {
			throw new EntityNotFoundException("il n’y a pas de prêt avec l'ID " + id);
		}

	}

	public Pret updatePret(Pret pret) {
		if (pretRepository.existsById(pret.getId())) {
			return pretRepository.save(pret);
		}
		throw new EntityNotFoundException("il n’y a pas de prêt avec l'ID " + pret.getId());
	}

	public Pret createPret(Pret pret) {
		return pretRepository.save(pret);
	}

	public Page<Pret> searchPretByStatut(String statut, Pageable pageable) {
		return pretRepository.findByStatut(statut, pageable);
	}

	public Page<Pret> searchPretByEmploye(String employeNom, Pageable pageable) {

		return pretRepository.findByEmployeNomContainingIgnoreCase(employeNom, pageable);
	}

}
