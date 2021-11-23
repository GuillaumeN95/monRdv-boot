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

import sopra.formation.model.Evaluation;
import sopra.formation.model.Views;
import sopra.formation.repository.IEvaluationRepository;

@RestController
@RequestMapping("/evaluation")
@CrossOrigin("*")
public class EvaluationRestController {

	@Autowired
	private IEvaluationRepository evaluationRepo;

	@GetMapping("")
	@JsonView(Views.ViewEvaluation.class)
	public List<Evaluation> findAll() {
		List<Evaluation> evaluations = evaluationRepo.findAll();

		return evaluations;
	}

	@GetMapping("{id}")
	@JsonView(Views.ViewEvaluation.class)
	public Evaluation find(@PathVariable Long id) {
		Optional<Evaluation> optEvaluation = evaluationRepo.findById(id);

		if (optEvaluation.isPresent()) {
			return optEvaluation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}
	}
	
	@GetMapping("{id}/detail")
	@JsonView(Views.ViewEvaluationDetail.class)
	public Evaluation detail(@PathVariable Long id) {
		Optional<Evaluation> optEvaluation = evaluationRepo.findById(id);

		if (optEvaluation.isPresent()) {
			return optEvaluation.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewEvaluation.class)
	public Evaluation create(@RequestBody Evaluation evaluation) {
		evaluation = evaluationRepo.save(evaluation);

		return evaluation;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewEvaluation.class)
	public Evaluation update(@PathVariable Long id, @RequestBody Evaluation evaluation) {
		if (!evaluationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}

		evaluation = evaluationRepo.save(evaluation);

		return evaluation;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ViewEvaluation.class)
	public Evaluation partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
		if (!evaluationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}

		Evaluation evaluationFind = evaluationRepo.findById(id).get();

		if (updates.containsKey("comportemental")) {
			evaluationFind.setComportemental((Integer) updates.get("comportemental"));
		}
		if (updates.containsKey("technique")) {
			evaluationFind.setTechnique((Integer) updates.get("technique"));
		}
		if (updates.containsKey("commentaires")) {
			evaluationFind.setCommentaires((String) updates.get("commentaires"));
		}
		if (updates.containsKey("dtEvaluation")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				evaluationFind.setDtEvaluation(sdf.parse((String) updates.get("dtEvaluation")));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		evaluationFind = evaluationRepo.save(evaluationFind);

		return evaluationFind;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		if (!evaluationRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Evaluation non trouvé");
		}
		
		evaluationRepo.deleteById(id);
	}

}
