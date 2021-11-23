package sopra.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("trainee")
@NamedQuery(name = "Stagiaire.findStagiaireByEmail", query = "select s from Stagiaire s where s.email = :email")
public class Stagiaire extends Personne {
	@Column(name = "birthdate")
	@Temporal(TemporalType.DATE)
	@Past
	private Date dtNaissance;
	@Enumerated(EnumType.STRING)
	@Column(name = "study_level", length = 10)
	private NiveauEtude niveauEtude;
	@ManyToOne
	@JoinColumn(name = "pathway_id")
	@JsonView(Views.ViewStagiaireDetail.class)
	private Filiere filiere;
	@OneToOne
	@JoinColumn(name = "rating_id")
	@JsonView(Views.ViewStagiaire.class)
	private Evaluation evaluation;

	public Stagiaire() {
		super();
	}

	public Stagiaire(String email) {
		super(email);
	}

	public Stagiaire(Civilite civilite, String nom, String prenom, String email, String telephone, Date dtNaissance,
			NiveauEtude niveauEtude) {
		super(civilite, nom, prenom, email, telephone);
		this.dtNaissance = dtNaissance;
		this.niveauEtude = niveauEtude;
	}

	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	public NiveauEtude getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(NiveauEtude niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

}
