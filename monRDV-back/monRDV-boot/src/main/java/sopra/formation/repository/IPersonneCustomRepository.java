package sopra.formation.repository;

import java.util.List;

import sopra.formation.model.Personne;

public interface IPersonneCustomRepository {
	List<Personne> findAllPersonneByNomAndPrenomAndEmail(String nom, String prenom, String email);
}
