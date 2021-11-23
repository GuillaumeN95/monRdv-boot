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

import sopra.formation.model.Salle;
import sopra.formation.model.Views;
import sopra.formation.repository.ISalleRepository;

@RestController
@RequestMapping("/salle")
@CrossOrigin("*")
public class SalleRestController {

	@Autowired
	private ISalleRepository salleRepo;

	@GetMapping("")
	@JsonView(Views.ViewSalle.class)
	public List<Salle> findAll() {
		List<Salle> salles = salleRepo.findAll();

		return salles;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewSalle.class)
	public Salle find(@PathVariable Long id) {
		Optional<Salle> optSalle = salleRepo.findById(id);

		if (optSalle.isPresent()) {
			return optSalle.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Salle non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewSalle.class)
	public Salle create(@RequestBody Salle salle, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Salle invalide !");
		}

		salle = salleRepo.save(salle);

		return salle;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSalle.class)
	public Salle update(@PathVariable Long id, @RequestBody Salle salle) {
		if (!salleRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Salle non trouvé");
		}

		salle = salleRepo.save(salle);

		return salle;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!salleRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Salle non trouvé");
		}

		salleRepo.deleteById(id);
	}

}
