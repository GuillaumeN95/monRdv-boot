package sopra.formation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.formation.model.Views.ViewEvaluationDetail;

@Entity
@Table(name = "rating")
@NamedQuery(name = "Evaluation.findByStagiaireId", query = "select s.evaluation from Stagiaire s where s.id = :idStagiaire")
@JsonView(Views.ViewCommon.class)
public class Evaluation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Version
	private int version;
	@Column(name = "behaviour")
	private Integer comportemental;
	@Column(name = "technical")
	private Integer technique;
	@Column(name = "comments")
	@Lob
	private String commentaires;
	@Temporal(TemporalType.DATE)
	@Column(name = "rating_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dtEvaluation;
	@OneToOne(mappedBy = "evaluation")
	@JsonView(ViewEvaluationDetail.class)
	private Stagiaire stagiaire;

	public Evaluation() {
		super();
	}

	public Evaluation(Integer comportemental, Integer technique, String commentaires) {
		super();
		this.comportemental = comportemental;
		this.technique = technique;
		this.commentaires = commentaires;
	}

	public Evaluation(Long id, Integer comportemental, Integer technique, String commentaires) {
		super();
		this.id = id;
		this.comportemental = comportemental;
		this.technique = technique;
		this.commentaires = commentaires;
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

	public Integer getComportemental() {
		return comportemental;
	}

	public void setComportemental(Integer comportemental) {
		this.comportemental = comportemental;
	}

	public Integer getTechnique() {
		return technique;
	}

	public void setTechnique(Integer technique) {
		this.technique = technique;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public Date getDtEvaluation() {
		return dtEvaluation;
	}

	public void setDtEvaluation(Date dtEvaluation) {
		this.dtEvaluation = dtEvaluation;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

}
