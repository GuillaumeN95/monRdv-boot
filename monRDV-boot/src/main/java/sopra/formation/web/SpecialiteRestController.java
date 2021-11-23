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
import sopra.formation.model.Specialite;
import sopra.formation.repository.ISpecialiteRepository;

@RestController
@RequestMapping("/specialite")
@CrossOrigin("*")
public class SpecialiteRestController {

	@Autowired
	private ISpecialiteRepository specialiteRepo;

	@GetMapping("")
	@JsonView(Views.ViewSpecialite.class)
	public List<Specialite> findAll() {
		List<Specialite> specialites = specialiteRepo.findAll();

		return specialites;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewSpecialite.class)
	public Specialite find(@PathVariable Long id) {
		Optional<Specialite> optSpecialite = specialiteRepo.findById(id);

		if (optSpecialite.isPresent()) {
			return optSpecialite.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "specialite non trouvé");
		}
	}
	
	@GetMapping("{id}/detail")
	@JsonView(Views.ViewSpecialiteDetail.class)
	public Specialite detail(@PathVariable Long id) {
		Optional<Specialite> optSpecialite = specialiteRepo.findById(id);

		if (optSpecialite.isPresent()) {
			return optSpecialite.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "specialite non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewSpecialite.class)
	public Specialite create(@RequestBody Specialite specialite) {
		specialite = specialiteRepo.save(specialite);

		return specialite;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSpecialite.class)
	public Specialite update(@PathVariable Long id, @RequestBody Specialite specialite) {
		if (!specialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "specialite non trouvé");
		}

		specialite = specialiteRepo.save(specialite);

		return specialite;
	}

	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!specialiteRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "specialite non trouvé");
		}
		
		specialiteRepo.deleteById(id);
	}

}
