package bessa.morangon.rafael.AdopetAPI.domain.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdocaoRequest {

    @Email
    private String emailTutor;
    @NotNull
    private Long idPet;

}
