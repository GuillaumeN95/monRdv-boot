package sopra.formation.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
@JsonView(Views.ViewCommon.class)
public class Adresse {
	@Column(name="street", length = 255)
	private String rue;
	@Column(name="addtionnal_details", length = 255)
	private String complement;
	@Column(name="zipcode", length = 10)
	private String codePostal;
	@Column(name="city", length = 255)
	private String ville;

	public Adresse() {
		super();
	}

	public Adresse(String rue, String complement, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
