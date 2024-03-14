package bessa.morangon.rafael.AdopetAPI.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "abrigo")
public class Abrigo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 100)
    private String nome;

    @NotBlank
    @Size(max = 50)
    private String telefone;
    @NotBlank
    @Email
    private String email;
    @Embedded
    @NotNull
    private Endereco endereco;
    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Pet> listaPets;

}
