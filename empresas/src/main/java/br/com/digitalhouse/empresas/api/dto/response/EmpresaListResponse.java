package br.com.digitalhouse.empresas.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmpresaListResponse {
    private UUID id;
    private String nome;
    private String cnpj;
}
