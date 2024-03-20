package bessa.morangon.rafael.AdopetAPI.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TutorDTO {

    private Long id;
    private String nome;
    private String email;

}
