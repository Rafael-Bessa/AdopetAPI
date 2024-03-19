package bessa.morangon.rafael.AdopetAPI.service;

import bessa.morangon.rafael.AdopetAPI.domain.dto.PetDTO;
import bessa.morangon.rafael.AdopetAPI.domain.dto.TutorDTO;
import bessa.morangon.rafael.AdopetAPI.domain.model.Pet;
import bessa.morangon.rafael.AdopetAPI.domain.repository.PetRepository;
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
public class PetService {
    
    @Autowired
    private PetRepository repository;
    @Autowired
    private ModelMapper mapper;
    
    public ResponseEntity<?> buscaPetPorID(long id) {
        
        Optional<Pet> pet = repository.findById(id);
        if(pet.isPresent()){
            return ResponseEntity.ok(mapper.map(pet.get(), PetDTO.class));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Page<?>> buscaTodosPets(Pageable pageable) {
        
        Page<Pet> todosPets = repository.findAll(pageable);
        if(todosPets.getTotalElements() == 0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todosPets.map(pet -> mapper.map(pet, PetDTO.class)));
    }

    public ResponseEntity<?> cadastraPet(Pet pet, UriComponentsBuilder builder) {
        repository.save(pet);
        PetDTO petDTO = mapper.map(pet, PetDTO.class);
        URI uri = builder.path("/pets/{id}").buildAndExpand(petDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(petDTO);
    }

    public ResponseEntity<?> atualizaPet(long id, Pet pet){
        Optional<Pet> petBuscado = repository.findById(id);
        if(petBuscado.isPresent()){
            petBuscado.get().setNome(pet.getNome());
            petBuscado.get().setIdade(pet.getIdade());
            petBuscado.get().setPorte(pet.getPorte());
            petBuscado.get().setCaminhoImagem(pet.getCaminhoImagem());
            petBuscado.get().setComportamento(pet.getComportamento());
            petBuscado.get().setAbrigo(pet.getAbrigo());
            return ResponseEntity.ok(mapper.map(petBuscado.get(), PetDTO.class));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<?> deletaPet(long id) {
        Optional<Pet> pet = repository.findById(id);
        if(pet.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
