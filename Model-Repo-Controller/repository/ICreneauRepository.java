package sopra.formation.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.formation.model.Creneau;



public interface ICreneauRepository extends JpaRepository<Creneau, Long> {
	
	//@Query("select c from Creneau c join c.praticien p where p.id = :idPraticien")
	//Optional<Creneau> findAllCreneauByIdPraticien(@Param("idPraticien") Long idPraticien);
	
	
	
	@Query("select c from Creneau c where c.praticien.id = :idPraticien and c.dispo=1")
	List<Creneau> findDispoByPraticien(@Param("idPraticien") Long idPraticien);
	
	
	@Query("select c from Creneau c where c.praticien.id = :idPraticien")
	List<Creneau> findByPraticien(@Param("idPraticien") Long idPraticien);
	

}
