package br.com.digitalhouse.empresas.api.controller;

import br.com.digitalhouse.empresas.api.dto.request.EmpresaRequest;
import br.com.digitalhouse.empresas.api.dto.response.ContatoResponse;
import br.com.digitalhouse.empresas.api.dto.response.EmpresaListResponse;
import br.com.digitalhouse.empresas.api.dto.response.EmpresaResponse;
import br.com.digitalhouse.empresas.api.dto.response.EmpresaWrapperResponse;
import br.com.digitalhouse.empresas.domain.entity.Contato;
import br.com.digitalhouse.empresas.domain.entity.Empresa;
import br.com.digitalhouse.empresas.domain.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * RestController: para indicar que essa classe é um entrypoint rest
 * <p>
 * RequestMapping: para indicar que todas as entradas dessa classe começarão
 * com v1/empresas, no exemplo chamando localmente: http://meuservidor:8080/v1/empresas
 */
@RestController
@RequestMapping("v1/empresas")
public class EmpresaController {
    private final EmpresaService empresaService;

    /**
     * Construtor com anotação @Autowired para indicar ao spring
     * que essa ele deve injetar um bean do tipo EmpresaService
     * para usarmos em nossa implementação.
     * <p>
     * Essa anotação usando Spring hoje é opcional.
     */
    @Autowired
    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    /**
     * Anotação indicando que o método abaixo é um endpoint, com o atributo id
     * criando o seguinte endpoint GET http://meuservidor:8080/v1/empresas/{id}
     * para buscarmos uma unica empresa
     */
    @GetMapping("{id}")

    ResponseEntity<EmpresaResponse> buscarPorId(@PathVariable UUID id) {
        Empresa empresa = empresaService.buscarEmpresaPorId(id);
        EmpresaResponse response = empresaResponseByEmpresa(empresa);
        return ResponseEntity.ok(response);
    }

    /**
     * Anotação indicando que o método abaixo é um endpoint
     * criando o seguinte endpoint GET http://meuservidor:8080/v1/empresas?termo=algum-termo
     * para buscarmos todas as empresas pelo parametro "termo"
     */
    @GetMapping
    ResponseEntity<EmpresaWrapperResponse> buscarTodosPorTermo(@RequestParam String termo) {
        List<Empresa> empresas = empresaService.buscarEmpresas(termo);
        EmpresaWrapperResponse empresaWrapperResponse = new EmpresaWrapperResponse();
        empresaWrapperResponse.setEmpresas(empresas.stream().map(empresa -> {
            EmpresaListResponse empresaListResponse = new EmpresaListResponse();
            empresaListResponse.setId(empresa.getId());
            empresaListResponse.setNome(empresa.getNome());
            empresaListResponse.setCnpj(empresa.getCnpj());
            return empresaListResponse;
        }).toList());
        return ResponseEntity.ok(empresaWrapperResponse);
    }

    /**
     * Anotação indicando que o método abaixo é um endpoint
     * criando o seguinte endpoint POST http://meuservidor:8080/v1/empresas
     * para criarmos uma empresa
     * <p>
     * Anotação @Valid: indica que temos um payload que deve ser validado
     * pelo hibernate.
     */
    @PostMapping
    ResponseEntity<?> criarEmpresa(@RequestBody @Valid EmpresaRequest request) {

        Empresa empresa = new Empresa();
        empresa.setCnpj(request.getCnpj());
        empresa.setNome(request.getNome());
        empresa.setNomeFantasia(request.getRazaoSocial());

        Contato contato = new Contato();
        contato.setEmail(request.getContato().getEmail());
        contato.setTelefone(request.getContato().getTelefone());

        empresa.setContato(contato);
        Empresa empresaCriada = empresaService.criar(empresa);
        return ResponseEntity.ok(empresaCriada.getId());
    }

    /**
     * O método abaixo é um metodo que transafor uma empresa em uma empresaResponse
     */
    private EmpresaResponse empresaResponseByEmpresa(Empresa empresa) {
        EmpresaResponse empresaResponse = new EmpresaResponse();
        empresaResponse.setNome(empresa.getNome());
        empresaResponse.setCnpj(empresa.getCnpj());
        empresaResponse.setRazaoSocial(empresa.getNomeFantasia());

        empresaResponse.setId(empresa.getId());
        ContatoResponse contato = new ContatoResponse();
        contato.setEmail(empresa.getContato().getEmail());
        contato.setId(empresa.getContato().getId());
        contato.setTelefone(empresa.getContato().getTelefone());

        empresaResponse.setContato(contato);
        return empresaResponse;
    }
}
