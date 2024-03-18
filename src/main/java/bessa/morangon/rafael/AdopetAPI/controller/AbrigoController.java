package bessa.morangon.rafael.AdopetAPI.controller;

import bessa.morangon.rafael.AdopetAPI.domain.model.Abrigo;
import bessa.morangon.rafael.AdopetAPI.domain.model.Tutor;
import bessa.morangon.rafael.AdopetAPI.service.AbrigoService;
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
@RequestMapping("/abrigos")
public class AbrigoController {
    @Autowired
    private AbrigoService service;
    @GetMapping("/{id}")
    public ResponseEntity<?>getAbrigoById(@PathVariable long id){
        return service.buscaAbrigoPorID(id);
    }
    @GetMapping
    public ResponseEntity<Page<?>> getAbrigos(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable){
        return service.buscaTodosAbrigos(pageable);
    }
    @PostMapping
    @Transactional
    public ResponseEntity<?> setAbrigo(@RequestBody @Valid Abrigo abrigo, UriComponentsBuilder builder){
        return service.cadastraAbrigo(abrigo, builder);
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<?> updateAbrigo(@PathVariable long id, @RequestBody @Valid Abrigo abrigo){
        return service.atualizaAbrigo(id, abrigo);
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<?> deleteAbrigo(@PathVariable long id){
        return service.deletaAbrigo(id);
    }


}
