package bessa.morangon.rafael.AdopetAPI.service;

import bessa.morangon.rafael.AdopetAPI.domain.dto.TutorDTO;
import bessa.morangon.rafael.AdopetAPI.domain.model.Tutor;
import bessa.morangon.rafael.AdopetAPI.domain.repository.TutorRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TutorService {
    private final TutorRepository tutorRepository;
    private final ModelMapper mapper;

    public ResponseEntity<?> buscaTutorPorID(long id){

        Optional<Tutor> tutorBuscado = tutorRepository.findById(id);
        if(tutorBuscado.isPresent()){
            return ResponseEntity.ok(mapper.map(tutorBuscado.get(), TutorDTO.class));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Page<?>> buscaTodosTutores(Pageable pageable) {

        Page<Tutor> todosTutores = tutorRepository.findAll(pageable);
        if(todosTutores.getTotalElements() == 0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todosTutores.map(tutor -> mapper.map(tutor, TutorDTO.class)));
    }

    public ResponseEntity<?> cadastraTutor(Tutor tutor, UriComponentsBuilder builder){

        tutorRepository.save(tutor);
        TutorDTO tutorDTO = mapper.map(tutor, TutorDTO.class);
        URI uri = builder.path("/tutores/{id}").buildAndExpand(tutorDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(tutorDTO);
    }

    public ResponseEntity<?> atualizaTutor(long id, Tutor tutor){

        Optional<Tutor> tutorBuscado = tutorRepository.findById(id);
        if(tutorBuscado.isPresent()){

            tutorBuscado.get().setEmail(tutor.getEmail());
            tutorBuscado.get().setNome(tutor.getNome());
            tutorBuscado.get().setSenha(tutor.getSenha());
            tutorRepository.save(tutorBuscado.get());
            return ResponseEntity.ok(tutorBuscado.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deletaTutor(long id){

        Optional<Tutor> tutorBuscado = tutorRepository.findById(id);
        if(tutorBuscado.isPresent()){
            tutorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }
}
