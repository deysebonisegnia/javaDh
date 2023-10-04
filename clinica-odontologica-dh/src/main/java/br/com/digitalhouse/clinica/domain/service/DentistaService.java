package br.com.digitalhouse.clinica.domain.service;

import br.com.digitalhouse.clinica.domain.entity.Dentista;

import java.util.Optional;

public interface DentistaService {

    Optional<Dentista> buscarPorId(Integer id);

    Dentista criarDentista(Dentista dentista);

    Dentista atualizarDentista(Dentista dentista);

}
