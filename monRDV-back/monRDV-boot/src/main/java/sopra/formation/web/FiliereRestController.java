package sopra.formation.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
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

import sopra.formation.model.Filiere;
import sopra.formation.model.Views;
import sopra.formation.repository.IFiliereRepository;

@RestController
@RequestMapping("/filiere")
@CrossOrigin("*")
public class FiliereRestController {

	@Autowired
	private IFiliereRepository filiereRepo;

	@GetMapping("")
	@JsonView(Views.ViewFiliere.class)
	public List<Filiere> findAll() {
		List<Filiere> filieres = filiereRepo.findAll();

		return filieres;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewFiliereWithStagiaires.class)
	public Filiere find(@PathVariable Long id) {
		Optional<Filiere> optFiliere = filiereRepo.findByIdWithStagiaire(id);

		if (optFiliere.isPresent()) {
			return optFiliere.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filière non trouvé");
		}
	}
	
	@GetMapping("{id}/with-ues")
	@JsonView(Views.ViewFiliereWithUes.class)
	public Filiere findWithUes(@PathVariable Long id) {
		Optional<Filiere> optFiliere = filiereRepo.findByIdWithUe(id);

		if (optFiliere.isPresent()) {
			return optFiliere.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filière non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewFiliere.class)
	public Filiere create(@RequestBody Filiere filiere, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Filière invalide !");
		}

		filiere = filiereRepo.save(filiere);

		return filiere;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFiliere.class)
	public Filiere update(@PathVariable Long id, @RequestBody Filiere filiere) {
		if (!filiereRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filière non trouvé");
		}

		filiere = filiereRepo.save(filiere);

		return filiere;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!filiereRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Filière non trouvé");
		}

		filiereRepo.deleteById(id);
	}

}
