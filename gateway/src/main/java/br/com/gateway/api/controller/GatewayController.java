package br.com.gateway.api.controller;

import br.com.gateway.api.controller.dto.response.ClienteDetalhadoResponse;
import br.com.gateway.api.controller.dto.response.ClienteResponse;
import br.com.gateway.api.controller.dto.response.ProdutoResponse;
import br.com.gateway.infrastructure.openfeign.ClientesClient;
import br.com.gateway.infrastructure.openfeign.ProdutoHttpClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
public class GatewayController {
    private final ProdutoHttpClient produtoHttpClient;
    private final ClientesClient clienteClient;
    @GetMapping("produtos")
    public ResponseEntity<List<ProdutoResponse>> buscarProdutosNoServico() {
        ResponseEntity<List<ProdutoResponse>> response =
                produtoHttpClient.buscarTodosOsProdutos();
        if (response.getStatusCode().isError()) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("clientes")
    public ResponseEntity<List<ClienteResponse>> buscarClientesNoServico() {
        ResponseEntity<List<ClienteResponse>> response =
                clienteClient.buscarTodosOsClientes();
        if (response.getStatusCode().isError()) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(response.getBody());
    }

    @GetMapping("resumo-da-compra")
    public ResponseEntity<ClienteDetalhadoResponse> buscarClienteComProdutos() {
        var produtos = produtoHttpClient.buscarTodosOsProdutos();
        var clientes = clienteClient.buscarTodosOsClientes();

        if (produtos.getStatusCode().isError() || clientes.getStatusCode().isError()) {
            return ResponseEntity.internalServerError().build();
        }

        ClienteResponse clienteResponse = clientes.getBody().get(0);
        ClienteDetalhadoResponse response =
                new ClienteDetalhadoResponse(
                        clienteResponse.getId(),
                        clienteResponse.getNome(),
                        produtos.getBody(),
                        new BigDecimal("1200.99"),
                        "Av Newton azevedo");

        return ResponseEntity.ok(response);
    }

}
