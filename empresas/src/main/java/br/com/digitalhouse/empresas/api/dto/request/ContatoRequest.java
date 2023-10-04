package br.com.digitalhouse.empresas.api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoRequest {
    private String email;
    private String telefone;
}
