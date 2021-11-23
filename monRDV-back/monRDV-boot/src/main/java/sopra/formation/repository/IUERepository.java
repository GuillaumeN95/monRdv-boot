package sopra.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Matiere;
import sopra.formation.model.UE;

public interface IUERepository extends JpaRepository<UE, Long> {
	List<Optional<UE>> findByMatiere(Matiere matiere); // convention de nommage

	@Query("select ue from UE ue where ue.filiere.id = :idFiliere")
	List<UE> findByFiliere(@Param("idFiliere") Long idFiliere);
}
