package br.com.gateway.api.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoResponse {
    private String id;
    private String nome;
    private String marca;
    private String cidade;
}
