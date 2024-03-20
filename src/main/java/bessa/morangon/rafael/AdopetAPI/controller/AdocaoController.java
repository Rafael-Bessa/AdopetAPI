package bessa.morangon.rafael.AdopetAPI.controller;


import bessa.morangon.rafael.AdopetAPI.domain.model.AdocaoRequest;
import bessa.morangon.rafael.AdopetAPI.domain.model.Pet;
import bessa.morangon.rafael.AdopetAPI.domain.model.Tutor;
import bessa.morangon.rafael.AdopetAPI.service.AdocaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class AdocaoController {

    @Autowired
    private AdocaoService service;

    @GetMapping("/tutores/{id}/adocoes")
    public ResponseEntity<?> getAdocaoByTutorId(@PathVariable long id){
        return service.buscaAdocaoPorIdTutor(id);
    }

    @PostMapping("/adocoes")
    @Transactional
    public ResponseEntity<?> insertAdocao(@RequestBody @Valid AdocaoRequest adocaoRequest, UriComponentsBuilder builder){
        return service.criaAdocao(adocaoRequest, builder);
    }





}
