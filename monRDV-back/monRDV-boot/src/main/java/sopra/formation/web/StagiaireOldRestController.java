package sopra.formation.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Stagiaire;
import sopra.formation.model.Views;
import sopra.formation.repository.IPersonneRepository;
import sopra.formation.web.exception.StagiaireValidationException;

@Controller
@RequestMapping("/stagiaireOld")
@CrossOrigin("*")
public class StagiaireOldRestController {
	
	@Autowired
	private IPersonneRepository personneRepo;

	@GetMapping("")
	@ResponseBody
	@JsonView(Views.ViewStagiaire.class)
	public List<Stagiaire> findAll() {
		List<Stagiaire> stagiaires = personneRepo.findAllStagiaire();
		
		return stagiaires;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewStagiaireDetail.class)
	public ResponseEntity<Stagiaire> find(@PathVariable Long id) {
		Optional<Stagiaire> optStagiaire = personneRepo.findStagiaireById(id);
		
		if(optStagiaire.isPresent()) {
			return new ResponseEntity<Stagiaire>(optStagiaire.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Stagiaire>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	@ResponseBody
	@JsonView(Views.ViewStagiaire.class)
	public Stagiaire create(@Valid @RequestBody Stagiaire stagiaire, BindingResult result) {
		if(result.hasErrors()) {
			throw new StagiaireValidationException();
		}
		
		stagiaire = personneRepo.save(stagiaire);
		
		return stagiaire;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewStagiaire.class)
	public ResponseEntity<Stagiaire> update(@PathVariable Long id, @RequestBody Stagiaire stagiaire) {
		if(!personneRepo.existsById(id)) {
			return new ResponseEntity<Stagiaire>(HttpStatus.NOT_FOUND);
		}
		
		stagiaire = personneRepo.save(stagiaire);
		
		return new ResponseEntity<Stagiaire>(stagiaire, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if (!personneRepo.existsById(id)) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		personneRepo.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
