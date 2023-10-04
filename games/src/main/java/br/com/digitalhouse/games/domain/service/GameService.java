package br.com.digitalhouse.games.domain.service;

import br.com.digitalhouse.games.domain.entity.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

public interface GameService {

    Page<Game> buscarGames(Pageable pageable);

    Game buscarPorId(UUID id);

    Game criarGame(Game game);

    Game atualizarGame(UUID id, Map<String, Object> campos);

    void excluirGame(UUID id);

}
