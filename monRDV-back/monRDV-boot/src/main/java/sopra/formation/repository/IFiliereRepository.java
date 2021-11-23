package sopra.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Filiere;

public interface IFiliereRepository extends JpaRepository<Filiere, Long> {
	@Query("select distinct f from Filiere f left join fetch f.referent r where f.id = :id")
	Filiere findByIdWithReferent(@Param("id") Long id); // @Query
	Filiere findByPromotion(String promotion); // par convention de nommage
	List<Filiere> findAllByVille(@Param("ville") String ville); // par NamedQuery
	
	@Query("select distinct f from Filiere f left join fetch f.stagiaires s where f.id = :id")
	Optional<Filiere> findByIdWithStagiaire(@Param("id") Long id);
	
	@Query("select distinct f from Filiere f left join fetch f.ues u where f.id = :id")
	Optional<Filiere> findByIdWithUe(@Param("id") Long id);
}
