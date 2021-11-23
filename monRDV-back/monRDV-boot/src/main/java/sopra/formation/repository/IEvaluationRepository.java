package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import sopra.formation.model.Evaluation;
import sopra.formation.model.Stagiaire;

public interface IEvaluationRepository extends JpaRepository<Evaluation, Long> {
	Evaluation findByStagiaireId(@Param("idStagiaire") Long idStagiaire); // Par NamedQuery Evaluation.findByStagiaireId

	@RestResource(path = "by-technique")
	List<Evaluation> findByTechnique(@Param("note") Integer technique); // Par Convention de nommage
	
	@Query("select e.comportemental, e.technique, e.commentaires from Stagiaire s join s.evaluation e where s = :stag")
	Object[] findEvaluationRawByStagiaire(@Param("stag") Stagiaire stagiaire); // Par Annotation @Query
	
	@Query("select distinct e from Evaluation e left join fetch e.stagiaire s")
	Evaluation findWithStagiaire();
	
	@Query("select e from Evaluation e left join e.stagiaire s where s is null or s.id = :idStagiaire")
	List<Evaluation> findAllOrphan(@Param("idStagiaire") Long idStagiaire);
}
