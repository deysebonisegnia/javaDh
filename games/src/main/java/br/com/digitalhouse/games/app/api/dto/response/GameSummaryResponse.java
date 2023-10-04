package br.com.digitalhouse.games.app.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
public class GameSummaryResponse {
    private UUID id;
    private String nome;
}
