package bessa.morangon.rafael.AdopetAPI.domain.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public record Endereco(@NotBlank String logradouro,
                       @NotBlank String bairro,
                       @NotBlank String cidade,
                       @NotBlank String estado,
                       @NotBlank String cep) {}

