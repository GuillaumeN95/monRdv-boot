package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "subject")
@JsonView(Views.ViewCommon.class)
public class Matiere {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name = "name", length = 100)
	private String nom;
	@Column(name = "duration")
	private Integer duree;
	@OneToMany(mappedBy = "matiere")
	@JsonView(Views.ViewMatiereWithUes.class)
	private List<UE> ues = new ArrayList<UE>();
	@ManyToMany(mappedBy = "competences")
	@JsonView(Views.ViewMatiereWithFormateurs.class)
	private List<Formateur> formateurs = new ArrayList<Formateur>();

	public Matiere() {
		super();
	}

	public Matiere(String nom, Integer duree) {
		super();
		this.nom = nom;
		this.duree = duree;
	}

	public Matiere(Long id, String nom, Integer duree) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
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

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public void addFormateur(Formateur formateur) {
		this.formateurs.add(formateur);
	}

}
