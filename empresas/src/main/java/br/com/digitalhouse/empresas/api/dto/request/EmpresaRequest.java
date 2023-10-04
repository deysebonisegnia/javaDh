package br.com.digitalhouse.empresas.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

@Getter
@Setter
public class EmpresaRequest {
    @NotBlank
    private String nome;
    @CNPJ
    private String cnpj;
    @NotNull
    private String razaoSocial;
    @NotNull
    private ContatoRequest contato;


}
