package bessa.morangon.rafael.AdopetAPI.domain.dto;

import bessa.morangon.rafael.AdopetAPI.domain.model.Porte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    private Long id;
    private String nome;
    private Integer idade;
    private Porte porte;
    private String comportamento;
    private String caminhoImagem;
    private Boolean adotado = false;
}
