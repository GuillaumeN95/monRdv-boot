package sopra.formation.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import sopra.formation.model.Personne;
import sopra.formation.repository.IPersonneCustomRepository;

public class IPersonneRepositoryCustomImpl implements IPersonneCustomRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Personne> findAllPersonneByNomAndPrenomAndEmail(String nom, String prenom, String email) {
		String queryString = "select p from Personne p where 1 = 1";
		
		if(nom != null && !nom.isBlank()) {
			queryString += " and p.nom = :nom";
		}
		
		if(prenom != null && !prenom.isBlank()) {
			queryString += " and p.prenom = :prenom";
		}
		
		if(email != null && !email.isBlank()) {
			queryString += " and p.email = :email";
		}
		
		TypedQuery<Personne> query = em.createQuery(queryString, Personne.class);

		if(nom != null && !nom.isBlank()) {
			query.setParameter("nom", nom);
		}
		
		if(prenom != null && !prenom.isBlank()) {
			query.setParameter("prenom", prenom);
		}
		
		if(email != null && !email.isBlank()) {
			query.setParameter("email", email);
		}
		
		return query.getResultList();
	}
	
	
}
