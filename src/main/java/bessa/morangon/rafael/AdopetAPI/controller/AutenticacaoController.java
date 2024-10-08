package bessa.morangon.rafael.AdopetAPI.controller;

import bessa.morangon.rafael.AdopetAPI.config.security.TokenJWTService;
import bessa.morangon.rafael.AdopetAPI.domain.dto.DadosAutenticacaoDTO;
import bessa.morangon.rafael.AdopetAPI.domain.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    /*
    Preciso criar o Bean do AuthenticationManager
     */

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenJWTService tokenJWTService;

    @PostMapping
    public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacaoDTO dados){

        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = authenticationManager.authenticate(token);

        return ResponseEntity.ok(tokenJWTService.gerarTokenJWT((Usuario)authentication.getPrincipal()));
    }

}
