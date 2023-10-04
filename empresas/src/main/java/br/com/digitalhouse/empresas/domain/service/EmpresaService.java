package br.com.digitalhouse.empresas.domain.service;

import br.com.digitalhouse.empresas.domain.entity.Empresa;

import java.util.List;
import java.util.UUID;

/**
 * Classe de contrato para nossa implementação do serviço
 * de empresa, possuindo os métodos de criar, buscar todas
 * as empresas com base em um termo
 * e buscar uma unica empresa pela sua identificação unica
 */
public interface EmpresaService {

    Empresa criar(Empresa empresa);

    List<Empresa> buscarEmpresas(String termo);

    Empresa buscarEmpresaPorId(UUID id);
}
