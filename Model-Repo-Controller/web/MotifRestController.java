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
import sopra.formation.model.Motif;
import sopra.formation.repository.IMotifRepository;

@RestController
@RequestMapping("/motif")
@CrossOrigin("*")
public class MotifRestController {

	@Autowired
	private IMotifRepository motifRepo;

	@GetMapping("")
	@JsonView(Views.ViewMotif.class)
	public List<Motif> findAll() {
		List<Motif> motifs = motifRepo.findAll();

		return motifs;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewMotif.class)
	public Motif find(@PathVariable Long id) {
		Optional<Motif> optMotif = motifRepo.findById(id);

		if (optMotif.isPresent()) {
			return optMotif.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "motif non trouvé");
		}
	}
	
	

	@PostMapping("")
	@JsonView(Views.ViewMotif.class)
	public Motif create(@RequestBody Motif motif) {
		motif = motifRepo.save(motif);

		return motif;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewMotif.class)
	public Motif update(@PathVariable Long id, @RequestBody Motif motif) {
		if (!motifRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "motif non trouvé");
		}

		motif = motifRepo.save(motif);

		return motif;
	}

	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!motifRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "motif non trouvé");
		}
		
		motifRepo.deleteById(id);
	}

}
