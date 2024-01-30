package com.ayoub.gestiondespret.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayoub.gestiondespret.model.Pret;
import com.ayoub.gestiondespret.repositories.PretRepository;

@Service
public class PretService {
	@Autowired
	private PretRepository pretRepository;

	public List<Pret> getAllPrets() {
		return pretRepository.findAll();
	}

	public Pret getPretById(Long id) {
		return pretRepository.findById(id).orElse(null);
	}

	public boolean deletePret(Long id) {

		if (pretRepository.existsById(id)) {

			pretRepository.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

	public void createPret(Pret pret) {
		pretRepository.save(pret);
	}

	public Pret updatePret(Pret pret) {
		return pretRepository.save(pret);
	}
}
