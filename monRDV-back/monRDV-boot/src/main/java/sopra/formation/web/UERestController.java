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

import sopra.formation.model.UE;
import sopra.formation.model.Views;
import sopra.formation.repository.IUERepository;

@RestController
@RequestMapping("/ue")
@CrossOrigin("*")
public class UERestController {

	@Autowired
	private IUERepository ueRepo;

	@GetMapping("")
	@JsonView(Views.ViewUE.class)
	public List<UE> findAll() {
		List<UE> ues = ueRepo.findAll();

		return ues;
	}

	@GetMapping("/by-filiere/{id}")
	@JsonView(Views.ViewUE.class)
	public List<UE> findAllByFiliere(@PathVariable("id") Long idFiliere) {
		List<UE> ues = ueRepo.findByFiliere(idFiliere);

		return ues;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewUE.class)
	public UE find(@PathVariable Long id) {
		Optional<UE> optUE = ueRepo.findById(id);

		if (optUE.isPresent()) {
			return optUE.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UE non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewUE.class)
	public UE create(@RequestBody UE ue) {
		ue = ueRepo.save(ue);

		return ue;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewUE.class)
	public UE update(@PathVariable Long id, @RequestBody UE ue) {
		if (!ueRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UE non trouvé");
		}

		ue = ueRepo.save(ue);

		return ue;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!ueRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UE non trouvé");
		}

		ueRepo.deleteById(id);
	}

}
