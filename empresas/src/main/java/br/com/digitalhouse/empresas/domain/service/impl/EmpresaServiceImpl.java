package br.com.digitalhouse.empresas.domain.service.impl;

import br.com.digitalhouse.empresas.domain.entity.Empresa;
import br.com.digitalhouse.empresas.domain.repository.EmpresaRepository;
import br.com.digitalhouse.empresas.domain.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementação concreta do serviço
 */
@Service
public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;

    /**
     * Construtor com anotação @Autowired para indicar ao spring
     * que essa ele deve injetar um bean do tipo EmpresaService
     * para usarmos em nossa implementação.
     * <p>
     * Essa anotação usando Spring hoje é opcional.
     */
    @Autowired
    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public Empresa criar(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> buscarEmpresas(String termo) {
        return this.empresaRepository.findAll();
    }

    @Override
    public Empresa buscarEmpresaPorId(UUID id) {
        return this.empresaRepository
                .findById(id)
                .orElseThrow();
    }
}
