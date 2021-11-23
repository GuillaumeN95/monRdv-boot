package sopra.formation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Matiere;

public interface IMatiereRepository extends JpaRepository<Matiere, Long> {
	Matiere findFirstByNom(String nom); // convention de nommage

	@Query("select distinct m from Matiere m left join fetch m.formateurs f where m.id = :id")
	Optional<Matiere> findByIdWithFormateurs(@Param("id") Long id);
}
