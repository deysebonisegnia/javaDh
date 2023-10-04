package br.com.digitalhouse.games.domain.exception;


import java.util.UUID;

public class GameNotFoundException extends RuntimeException {

    public GameNotFoundException(UUID gameId) {
        super("game com id: %s não encontrado! Reveja o que foi solicitado.".formatted(gameId));
    }

}
