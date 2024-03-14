package bessa.morangon.rafael.AdopetAPI.domain.model;

import jakarta.persistence.Embeddable;
@Embeddable
public record Endereco(String rua, String cidade, String estado, String cep) {}

