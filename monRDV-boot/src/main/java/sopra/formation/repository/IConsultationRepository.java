package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Consultation;

public interface IConsultationRepository extends JpaRepository<Consultation, Long> {

}
