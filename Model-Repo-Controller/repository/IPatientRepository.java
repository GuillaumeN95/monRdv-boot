package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Long> {

	
	
}
