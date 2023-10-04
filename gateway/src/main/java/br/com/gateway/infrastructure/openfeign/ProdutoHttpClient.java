package br.com.gateway.infrastructure.openfeign;

import br.com.gateway.api.controller.dto.response.ProdutoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "produtos")
public interface ProdutoHttpClient {

    @GetMapping("v1/produtos")
    ResponseEntity<List<ProdutoResponse>> buscarTodosOsProdutos();
}
