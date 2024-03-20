package bessa.morangon.rafael.AdopetAPI.domain.dto;

import bessa.morangon.rafael.AdopetAPI.domain.model.Pet;
import bessa.morangon.rafael.AdopetAPI.domain.model.Tutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdocaoDTO {

    private UUID id;
    private Pet pet;
    private TutorDTO tutor;
    private LocalDate data = LocalDate.now();

}
