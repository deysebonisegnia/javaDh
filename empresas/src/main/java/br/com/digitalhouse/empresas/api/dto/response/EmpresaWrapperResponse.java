package br.com.digitalhouse.empresas.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmpresaWrapperResponse {
    private List<EmpresaListResponse> empresas;
}
