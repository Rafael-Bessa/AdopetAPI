package bessa.morangon.rafael.AdopetAPI.service;

import bessa.morangon.rafael.AdopetAPI.domain.dto.AdocaoDTO;

import bessa.morangon.rafael.AdopetAPI.domain.dto.PetDTO;
import bessa.morangon.rafael.AdopetAPI.domain.dto.TutorDTO;
import bessa.morangon.rafael.AdopetAPI.domain.model.Adocao;
import bessa.morangon.rafael.AdopetAPI.domain.model.AdocaoRequest;
import bessa.morangon.rafael.AdopetAPI.domain.model.Pet;
import bessa.morangon.rafael.AdopetAPI.domain.model.Tutor;
import bessa.morangon.rafael.AdopetAPI.domain.repository.AdocaoRepository;
import bessa.morangon.rafael.AdopetAPI.domain.repository.PetRepository;
import bessa.morangon.rafael.AdopetAPI.domain.repository.TutorRepository;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AdocaoService {

    private AdocaoRepository adocaoRepository;
    private TutorRepository tutorRepository;
    private PetRepository petRepository;
    private ModelMapper mapper;


    public ResponseEntity<?> buscaAdocaoPorIdTutor(long id) {

       Optional<List<Adocao>> adocao = adocaoRepository.findByTutorId(id);

        if(adocao.isPresent()){
            return ResponseEntity.ok(adocao.get().stream().map(adocao1 ->
                    new PetDTO(adocao1.getPet().getId(),
                            adocao1.getPet().getNome(),
                            adocao1.getPet().getIdade(),
                            adocao1.getPet().getPorte(),
                            adocao1.getPet().getComportamento(),
                            adocao1.getPet().getCaminhoImagem(),
                            adocao1.getPet().getAdotado())));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> criaAdocao(AdocaoRequest adocaoRequest, UriComponentsBuilder builder) {

        Optional<Tutor> tutorBuscado = tutorRepository.findByEmail(adocaoRequest.getEmailTutor());
        Optional<Pet> petBuscado = petRepository.findById(adocaoRequest.getIdPet());

        if(tutorBuscado.isPresent() && petBuscado.isPresent()){
            Adocao adocao = new Adocao();
            adocao.setPet(petBuscado.get());
            adocao.setTutor(tutorBuscado.get());
            petBuscado.get().setAdotado(true);
            adocaoRepository.save(adocao);

           AdocaoDTO adocaoDTO = mapper.map(adocao, AdocaoDTO.class);
           URI uri = UriComponentsBuilder.fromPath("/adocoes/{id}").build().toUri();
           URI uriComId = UriComponentsBuilder.fromUri(uri).buildAndExpand(adocaoDTO.getId()).toUri();
           return ResponseEntity.created(uriComId).body(adocaoDTO);
        }
        return ResponseEntity.badRequest().build();
    }
}
