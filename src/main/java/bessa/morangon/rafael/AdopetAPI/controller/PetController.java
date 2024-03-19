package bessa.morangon.rafael.AdopetAPI.controller;

import bessa.morangon.rafael.AdopetAPI.domain.model.Pet;
import bessa.morangon.rafael.AdopetAPI.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPetByID(@PathVariable long id){
        return service.buscaPetPorID(id);
    }
    @GetMapping
    public ResponseEntity<Page<?>> getPets(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        return service.buscaTodosPets(pageable);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> insertPet(@RequestBody @Valid Pet pet, UriComponentsBuilder builder){
        return service.cadastraPet(pet, builder);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> updatePet(@RequestBody @Valid Pet pet, @PathVariable long id){
        return service.atualizaPet(id,pet);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deletePet(@PathVariable long id){
        return service.deletaPet(id);
    }

}
