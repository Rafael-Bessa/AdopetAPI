package bessa.morangon.rafael.AdopetAPI.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    private String nome;
    @NotBlank
    private String telefone;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @Embedded
    @NotNull
    private Endereco endereco;
    @OneToMany(mappedBy = "abrigo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Pet> listaPets;
}
