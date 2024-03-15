package bessa.morangon.rafael.AdopetAPI.domain.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
public record Endereco(@NotBlank String logradouro,
                       @NotBlank String bairro,
                       @NotBlank String cidade,
                       @NotBlank @Size(max = 2) String estado,
                       @NotBlank String cep) {}

