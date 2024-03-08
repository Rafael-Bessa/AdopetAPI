package bessa.morangon.rafael.AdopetAPI.controller;

import bessa.morangon.rafael.AdopetAPI.domain.dto.TutorDTO;
import bessa.morangon.rafael.AdopetAPI.domain.model.Tutor;
import bessa.morangon.rafael.AdopetAPI.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/tutores")
public class TutoresController {

    @Autowired
    TutorService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTutorById(@PathVariable long id){
        return service.buscaTutorPorID(id);
    }

    @GetMapping
    public ResponseEntity<Page<?>> getTutores(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        return service.buscaTodosTutores(pageable);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TutorDTO> cadastraTutor(@RequestBody @Valid Tutor tutor, UriComponentsBuilder builder){

        TutorDTO tutorDTO = service.cadastraTutor(tutor);
        URI uri = builder.path("/tutores/{id}").buildAndExpand(tutorDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(tutorDTO);
    }

}
