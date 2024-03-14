package bessa.morangon.rafael.AdopetAPI.domain.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 100)
    private String nome;
    private Integer idade;
    @NotNull
    @Valid
    private Porte porte;
    @NotBlank
    @Size(max = 255)
    private String comportamento;
    private String caminhoImagem;
    @NotNull
    @ManyToOne
    private Abrigo abrigo;

}