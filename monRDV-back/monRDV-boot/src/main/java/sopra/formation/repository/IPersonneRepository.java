package sopra.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Formateur;
import sopra.formation.model.Personne;
import sopra.formation.model.Stagiaire;

public interface IPersonneRepository extends JpaRepository<Personne, Long>, IPersonneCustomRepository {
	@Query("select s from Stagiaire s")
	List<Stagiaire> findAllStagiaire(); // @Query

	@Query("select f from Formateur f")
	List<Formateur> findAllFormateur(); // @Query
	
	@Query("select distinct f from Formateur f left join fetch f.competences c")
	List<Formateur> findAllFormateurWithMatieres(); // @Query

	Stagiaire findStagiaireByEmail(@Param("email") String email); // NamedQuery

	Formateur findFormateurByEmail(@Param("email") String email); // NamedQuery

	@Query("select f from Matiere m join m.formateurs f where m.id = :id")
	List<Formateur> findAllFormateur(@Param("id") Long idMatiere); // @Query

	@Query("select p from Personne p where p.adresse.ville = :ville")
	List<Personne> findAllPersonneByVille(@Param("ville") String ville); // @Query

	@Query("select s from Stagiaire s where s.id = :id")
	Optional<Stagiaire> findStagiaireById(@Param("id") Long id);
	
	@Query("select f from Formateur f where f.id = :id")
	Optional<Formateur> findFormateurById(@Param("id") Long id);
	
	@Query("select distinct f from Formateur f left join fetch f.competences c where f.id = :id")
	Optional<Formateur> findFormateurByIdWithMatieres(@Param("id") Long id);
	
	@Query("select distinct f from Formateur f left join fetch f.ues ue where f.id = :id")
	Optional<Formateur> findFormateurByIdWithUes(@Param("id") Long id);
}
