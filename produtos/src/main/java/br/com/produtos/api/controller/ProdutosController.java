package br.com.produtos.api.controller;

import br.com.produtos.api.controller.dto.response.ProdutoResponse;
import com.github.javafaker.Faker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("v1/produtos")
public class ProdutosController {

    private static final Faker faker = new Faker(new Locale("pt", "BR"));

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> buscarTodos() {
        List<ProdutoResponse> produtos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            produtos.add(new ProdutoResponse(
                    faker.internet().uuid(),
                    "action figure: " + faker.rickAndMorty().character(),
                    faker.pokemon().name(),
                    faker.address().city()));
        }
        return ResponseEntity.ok(produtos);
    }
}
