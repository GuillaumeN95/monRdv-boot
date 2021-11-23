package sopra.formation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.formation.model.Lieu;

public interface ILieuRepository extends JpaRepository<Lieu, Long> {

}
