package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Filiere;
import sopra.formation.model.Salle;

public interface ISalleRepository extends JpaRepository<Salle, Long> {
	@Query("select ue.salle from UE ue where ue.filiere = :filiere")
	List<Salle> findAllByFiliere(@Param("filiere") Filiere filiere); // @Query
	
	@Query("select s from Salle s where s.adr.ville = :ville")
	List<Salle> findAllByVille(@Param("ville") String ville); // @Query
}
