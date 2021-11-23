package sopra.formation.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Formateur;
import sopra.formation.model.Views;
import sopra.formation.repository.IPersonneRepository;

@RestController
@RequestMapping("/formateur")
@CrossOrigin("*")
public class FormateurRestController {

	@Autowired
	private IPersonneRepository personneRepo;

	@GetMapping("")
	@JsonView(Views.ViewFormateurWithCompetences.class)
	public List<Formateur> findAll() {
		List<Formateur> formateurs = personneRepo.findAllFormateurWithMatieres();

		return formateurs;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewFormateurWithCompetences.class)
	public Formateur find(@PathVariable Long id) {
		Optional<Formateur> optFormateur = personneRepo.findFormateurByIdWithMatieres(id);

		if (optFormateur.isPresent()) {
			return optFormateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Formateur non trouvé");
		}
	}
	
	@GetMapping("{id}/with-ues")
	@JsonView(Views.ViewFormateurWithUes.class)
	public Formateur findWithUes(@PathVariable Long id) {
		Optional<Formateur> optFormateur = personneRepo.findFormateurByIdWithUes(id);

		if (optFormateur.isPresent()) {
			return optFormateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Formateur non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewFormateur.class)
	public Formateur create(@RequestBody Formateur formateur) {
		formateur = personneRepo.save(formateur);

		return formateur;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFormateur.class)
	public Formateur update(@PathVariable Long id, @RequestBody Formateur formateur) {
		if (!personneRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Formateur non trouvé");
		}

		formateur = personneRepo.save(formateur);

		return formateur;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!personneRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Formateur non trouvé");
		}

		personneRepo.deleteById(id);
	}

}
