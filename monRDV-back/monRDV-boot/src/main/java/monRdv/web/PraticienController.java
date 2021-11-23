package monRdv.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import monRdv.web.validator.EvaluationValidator;
import sopra.monRdv.model.Civilite;
import sopra.monRdv.model.Creneau;
import sopra.monRdv.model.Lieu;
import sopra.monRdv.model.Praticien;
import sopra.monRdv.model.Secteur;
import sopra.monRdv.model.Specialite;
import sopra.monRdv.repository.IPraticienRepository;

@Controller
@RequestMapping("/praticien")
public class PraticienController {
  
	@Autowired
	private IPraticienRepository praticienRepo = null;

	// ETAPE 1 : Réception de la requête
	@GetMapping({ "", "/list" })
	public String list(Model model) {
		// ETAPE 2 : Récupération des données
		List<Praticien> praticiens = praticienRepo.findAll();

		// ETAPE 3 : Renseigner les données du Model (en les nommant)
		model.addAttribute("praticiens", praticiens);

		// ETAPE 4 : Appel de la Vue
		return "praticien/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("prat", new Praticien());

		return "praticien/form";
	}

	@GetMapping("/edit")
	public String edit(Model model, @RequestParam Long id) {
		Optional<Praticien> optPraticien = praticienRepo.findById(id);

		if (optPraticien.isPresent()) {
			model.addAttribute("prat", optPraticien.get());

			return "praticien/form";
		} else {
			return "forward:list";
		}
	}

	@PostMapping("/save")
	public String save(@RequestParam(required = false) Long id,
			@RequestParam(required = false, defaultValue = "0") Integer version, @RequestParam Civilite civilite,
			@RequestParam String nom, @RequestParam String prenom, @RequestParam String telephone, @RequestParam Secteur secteur,
			@RequestParam boolean carteVitale, @RequestParam String photo, @RequestParam boolean cheque, @RequestParam boolean espece,
			@RequestParam Integer dureeCreneau, @RequestParam List<Specialite> specialites, @RequestParam List<Creneau> creneaux,
			@RequestParam List<Lieu> lieux){

		Praticien praticien = new Praticien();
		praticien.setId(id);
		praticien.setVersion(version);
		praticien.setCivilite(civilite);
		praticien.setNom(nom);
		praticien.setPrenom(prenom);	
		praticien.setTelephone(telephone);
		praticien.setSecteur(secteur);
		praticien.setCarteVitale(carteVitale);
		praticien.setPhoto(photo);
		praticien.setCheque(cheque);
		praticien.setEspece(espece);
		praticien.setDureeCreneau(dureeCreneau);
		praticien.setSpecialites(specialites);
		praticien.setCreneaux(creneaux);
		praticien.setLieux(lieux);

		praticienRepo.save(praticien);

		return "redirect:list";
	}
	
	@PostMapping("/saveBis")
	public String saveBis(@ModelAttribute("prat") @Valid Praticien praticien, BindingResult result) {
		
		new EvaluationValidator().validate(praticien, result);
		
		if(result.hasErrors()) {
			return "praticien/form";
		}

		praticienRepo.save(praticien);

		return "redirect:list";
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "forward:list";
	}

	@GetMapping("/remove")
	public String remove(@RequestParam Long id) {
		praticienRepo.deleteById(id);

		return "redirect:list";
	}

}
