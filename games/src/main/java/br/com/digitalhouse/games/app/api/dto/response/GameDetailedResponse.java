package br.com.digitalhouse.games.app.api.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class GameDetailedResponse {
    private UUID id;
    private String nome;
    private List<String> generos;
    private LocalDate lancamento;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;
}
