package br.com.digitalhouse.clinica.dao;

import br.com.digitalhouse.clinica.domain.entity.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Integer> {
}
