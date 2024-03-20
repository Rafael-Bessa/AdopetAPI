package bessa.morangon.rafael.AdopetAPI.domain.repository;

import bessa.morangon.rafael.AdopetAPI.domain.model.Adocao;
import bessa.morangon.rafael.AdopetAPI.domain.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AdocaoRepository extends JpaRepository<Adocao, UUID> {
    Optional<List<Adocao>> findByTutorId(long id);
}
