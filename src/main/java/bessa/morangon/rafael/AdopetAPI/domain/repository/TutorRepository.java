package bessa.morangon.rafael.AdopetAPI.domain.repository;

import bessa.morangon.rafael.AdopetAPI.domain.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Optional<Tutor> findByEmail(String email);
}
