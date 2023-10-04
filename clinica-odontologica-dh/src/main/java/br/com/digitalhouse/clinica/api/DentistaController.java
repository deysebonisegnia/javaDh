package br.com.digitalhouse.clinica.api;

import br.com.digitalhouse.clinica.domain.entity.Dentista;
import br.com.digitalhouse.clinica.domain.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dentistas")
public class DentistaController {

    private final DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @GetMapping("{id}")
    Dentista buscarPorId(@PathVariable Integer id) {
        return dentistaService.buscarPorId(id)
                .orElseThrow();
    }

    @PostMapping
    ResponseEntity<Dentista> criarDentista(@RequestBody Dentista dentista) {
        return ResponseEntity
                .status(201)
                .header("usuarioId", "asdasjldkajd")
                .body(dentistaService.criarDentista(dentista));
    }

    @PutMapping("{id}")
    Dentista atualizarDentista(@PathVariable Integer id, @RequestBody Dentista dentista) {
        dentista.setId(id);
        return dentistaService.atualizarDentista(dentista);
    }
}
