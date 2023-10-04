package br.com.digitalhouse.empresas.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmpresaResponse {
    private UUID id;
    private String nome;
    private String razaoSocial;
    private String cnpj;
    private ContatoResponse contato;
}
