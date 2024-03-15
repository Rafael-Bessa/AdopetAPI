package bessa.morangon.rafael.AdopetAPI.service;

import bessa.morangon.rafael.AdopetAPI.domain.dto.AbrigoDTO;
import bessa.morangon.rafael.AdopetAPI.domain.dto.TutorDTO;
import bessa.morangon.rafael.AdopetAPI.domain.model.Abrigo;
import bessa.morangon.rafael.AdopetAPI.domain.model.Tutor;
import bessa.morangon.rafael.AdopetAPI.domain.repository.AbrigoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class AbrigoService {
    @Autowired
    private AbrigoRepository abrigoRepository;
    @Autowired
    private ModelMapper mapper;

    public ResponseEntity<?> buscaAbrigoPorID(long id) {

        Optional<Abrigo> abrigo = abrigoRepository.findById(id);

        if(abrigo.isPresent()){
            return ResponseEntity.ok(mapper.map(abrigo, AbrigoDTO.class));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Page<?>> buscaTodosAbrigos(Pageable pageable) {

        Page<Abrigo> todosAbrigos = abrigoRepository.findAll(pageable);
        if(todosAbrigos.getTotalElements() == 0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todosAbrigos.map(abrigo -> mapper.map(abrigo, AbrigoDTO.class)));
    }

    public ResponseEntity<?> cadastraAbrigo(Abrigo abrigo, UriComponentsBuilder builder){

        abrigoRepository.save(abrigo);
        AbrigoDTO abrigoDTO = mapper.map(abrigo, AbrigoDTO.class);
        URI uri = builder.path("/abrigos/{id}").buildAndExpand(abrigoDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(abrigoDTO);
    }
}