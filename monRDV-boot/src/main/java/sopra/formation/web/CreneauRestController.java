package sopra.formation.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Views;
import sopra.formation.model.Creneau;
import sopra.formation.repository.ICreneauRepository;

@RestController
@RequestMapping("/creneau")
@CrossOrigin("*")
public class CreneauRestController {

	@Autowired
	private ICreneauRepository creneauRepo;

	@GetMapping("")
	@JsonView(Views.ViewCreneau.class)
	public List<Creneau> findAll() {
		List<Creneau> creneaus = creneauRepo.findAll();

		return creneaus;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewCreneau.class)
	public Creneau find(@PathVariable Long id) {
		Optional<Creneau> optCreneau = creneauRepo.findById(id);

		if (optCreneau.isPresent()) {
			return optCreneau.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "creneau non trouvé");
		}
	}
	
	@GetMapping("{id}/detail")
	@JsonView(Views.ViewCreneauDetail.class)
	public Creneau detail(@PathVariable Long id) {
		Optional<Creneau> optCreneau = creneauRepo.findById(id);

		if (optCreneau.isPresent()) {
			return optCreneau.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "creneau non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewCreneau.class)
	public Creneau create(@RequestBody Creneau creneau) {
		creneau = creneauRepo.save(creneau);

		return creneau;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCreneau.class)
	public Creneau update(@PathVariable Long id, @RequestBody Creneau creneau) {
		if (!creneauRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "creneau non trouvé");
		}

		creneau = creneauRepo.save(creneau);

		return creneau;
	}

	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!creneauRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "creneau non trouvé");
		}
		
		creneauRepo.deleteById(id);
	}

}
