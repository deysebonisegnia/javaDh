package br.com.digitalhouse.clinica.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Slf4j
public class Dentista {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 80)
    private String nome;

    @Column(length = 80)
    private String sobrenome;

    @Column(length = 12, nullable = false)
    private String cro;

    private LocalDate dataNascimento;

    @Column(updatable = false)
    private Instant createdAt;

    private Instant updatedAt;

    @PrePersist
    public void naCriacao() {
        this.createdAt = Instant.now();
        log.info("Executando antes de criar o registro");

    }

    @PreUpdate
    public void naAtualizacao() {
        this.updatedAt = Instant.now();
        log.info("Executando antes de atualizar registro");

    }

}
