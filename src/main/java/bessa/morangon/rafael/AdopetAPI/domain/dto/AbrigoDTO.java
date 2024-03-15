package bessa.morangon.rafael.AdopetAPI.domain.dto;

import bessa.morangon.rafael.AdopetAPI.domain.model.Endereco;
import bessa.morangon.rafael.AdopetAPI.domain.model.Pet;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbrigoDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private Endereco endereco;
    private List<Pet> listaPets;
}
