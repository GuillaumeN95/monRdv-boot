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
import sopra.formation.model.Lieu;
import sopra.formation.repository.ILieuRepository;

@RestController
@RequestMapping("/lieu")
@CrossOrigin("*")
public class LieuRestController {

	@Autowired
	private ILieuRepository lieuRepo;

	@GetMapping("")
	@JsonView(Views.ViewLieu.class)
	public List<Lieu> findAll() {
		List<Lieu> lieus = lieuRepo.findAll();

		return lieus;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewLieu.class)
	public Lieu find(@PathVariable Long id) {
		Optional<Lieu> optLieu = lieuRepo.findById(id);

		if (optLieu.isPresent()) {
			return optLieu.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "lieu non trouvé");
		}
	}
	
	@GetMapping("{id}/detail")
	@JsonView(Views.ViewLieuDetail.class)
	public Lieu detail(@PathVariable Long id) {
		Optional<Lieu> optLieu = lieuRepo.findById(id);

		if (optLieu.isPresent()) {
			return optLieu.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "lieu non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewLieu.class)
	public Lieu create(@RequestBody Lieu lieu) {
		lieu = lieuRepo.save(lieu);

		return lieu;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewLieu.class)
	public Lieu update(@PathVariable Long id, @RequestBody Lieu lieu) {
		if (!lieuRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "lieu non trouvé");
		}

		lieu = lieuRepo.save(lieu);

		return lieu;
	}

	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!lieuRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "lieu non trouvé");
		}
		
		lieuRepo.deleteById(id);
	}

}
