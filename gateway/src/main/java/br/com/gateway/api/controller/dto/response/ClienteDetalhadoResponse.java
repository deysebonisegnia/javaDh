package br.com.gateway.api.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"id", "nome", "total", "enderecoDeCobranca", "produtos"})
public class ClienteDetalhadoResponse {
    private String id;
    private String nome;
    private List<ProdutoResponse> produtos;
    private BigDecimal total;
    private String enderecoDeCobranca;

}
