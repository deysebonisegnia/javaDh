package br.com.digitalhouse.empresas.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 80, nullable = false)
    private String nome;

    @Column(length = 120, nullable = false)
    private String nomeFantasia;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "contato_id",
            referencedColumnName = "id",
            foreignKey =
            @ForeignKey(name = "fk_contato_empresa"))
    private Contato contato;

}
