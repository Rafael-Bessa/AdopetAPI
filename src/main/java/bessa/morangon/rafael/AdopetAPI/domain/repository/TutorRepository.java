package bessa.morangon.rafael.AdopetAPI.domain.repository;

import bessa.morangon.rafael.AdopetAPI.domain.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {

}
