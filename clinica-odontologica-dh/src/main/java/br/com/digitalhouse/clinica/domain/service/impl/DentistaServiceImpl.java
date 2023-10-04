package br.com.digitalhouse.clinica.domain.service.impl;

import br.com.digitalhouse.clinica.dao.DentistaRepository;
import br.com.digitalhouse.clinica.domain.entity.Dentista;
import br.com.digitalhouse.clinica.domain.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DentistaServiceImpl implements DentistaService {
    private final DentistaRepository dentistaRepository;

    @Autowired
    public DentistaServiceImpl(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    @Override
    public Optional<Dentista> buscarPorId(Integer id) {
        return dentistaRepository.findById(id);
    }

    @Override
    public Dentista criarDentista(Dentista dentista) {
        return dentistaRepository.save(dentista);
    }

    @Override
    public Dentista atualizarDentista(Dentista dentista) {
        return dentistaRepository.save(dentista);
    }
}
