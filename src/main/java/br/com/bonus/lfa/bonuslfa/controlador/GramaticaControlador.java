package br.com.bonus.lfa.bonuslfa.controlador;

import br.com.bonus.lfa.bonuslfa.dominio.Gramatica;
import br.com.bonus.lfa.bonuslfa.servico.interfaceService.GramaticaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/gramatica")
public class GramaticaControlador {

    @Autowired
    private GramaticaServico gramaticaServico;

    @PostMapping(
            value = "/normalizacao",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity normalizacao(@RequestBody Gramatica gramatica) {
         Gramatica gramaticaNormalizada = gramaticaServico.normalizacao(gramatica);
        return new ResponseEntity<>(gramaticaNormalizada, HttpStatus.CREATED);
    }
}
