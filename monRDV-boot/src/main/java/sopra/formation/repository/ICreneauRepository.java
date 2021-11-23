package sopra.formation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Creneau;


public interface ICreneauRepository extends JpaRepository<Creneau, Long> {
	
	@Query("select c from Creneau c join c.praticien p where p.id = :idPraticien")
	List<Creneau> findAllCreneauByIdPraticien(@Param("idPraticien") Long idPraticien);
	
	

}
