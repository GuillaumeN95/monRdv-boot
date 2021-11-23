package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("trainer")
@NamedQuery(name = "Formateur.findStagiaireByEmail", query = "select f from Formateur f where f.email = :email")
public class Formateur extends Personne {
	@Column(name = "executive")
	private Boolean referent;
	private Integer experience;
	@OneToMany(mappedBy = "formateur")
	@JsonView(Views.ViewFormateurWithUes.class)
	private List<UE> ues = new ArrayList<UE>();
	@ManyToMany
	@JoinTable(name = "skills", joinColumns = @JoinColumn(name = "trainer_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
			"trainer_id", "subject_id" }))
	@JsonView(Views.ViewFormateurWithCompetences.class)
	private List<Matiere> competences = new ArrayList<Matiere>();

	public Formateur() {
		super();
	}

	public Formateur(String email) {
		super(email);
	}

	public Formateur(Civilite civilite, String nom, String prenom, String email, String telephone, Boolean referent,
			Integer experience) {
		super(civilite, nom, prenom, email, telephone);
		this.referent = referent;
		this.experience = experience;
	}

	public Boolean getReferent() {
		return referent;
	}

	public void setReferent(Boolean referent) {
		this.referent = referent;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public List<UE> getUes() {
		return ues;
	}

	public void setUes(List<UE> ues) {
		this.ues = ues;
	}

	public void addUe(UE ue) {
		this.ues.add(ue);
	}

	public List<Matiere> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Matiere> competences) {
		this.competences = competences;
	}

	public void addCompetence(Matiere matiere) {
		this.competences.add(matiere);
	}

}
