package br.com.digitalhouse.games.app.api.controller;

import br.com.digitalhouse.games.app.api.GamesApi;
import br.com.digitalhouse.games.app.api.dto.request.CreateGameRequest;
import br.com.digitalhouse.games.app.api.dto.response.GameDetailedResponse;
import br.com.digitalhouse.games.app.api.dto.response.GameSummaryResponse;
import br.com.digitalhouse.games.domain.entity.Game;
import br.com.digitalhouse.games.domain.service.GameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
public class GamesController implements GamesApi {
    private final GameService gameService;
    private final ObjectMapper mapper;

    @Autowired
    public GamesController(GameService gameService, ObjectMapper mapper) {
        this.gameService = gameService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<GameSummaryResponse>> buscarGames(Pageable pageable) {
        Page<Game> gamePage = gameService.buscarGames(pageable);

        Page<GameSummaryResponse> response = gamePage
                .map(game -> new GameSummaryResponse(game.getId(), game.getNome()));

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<GameDetailedResponse> criarGame(CreateGameRequest request) {
        Game game = mapper.convertValue(request, Game.class);
        Game gameCriado = gameService.criarGame(game);

        GameDetailedResponse gameDetailedResponse = gameParaGameDetailedResponse(gameCriado);

        return ResponseEntity.status(HttpStatus.CREATED).body(gameDetailedResponse);
    }

    @Override
    public ResponseEntity<GameDetailedResponse> buscarGamePorId(UUID id) {
        Game game = gameService.buscarPorId(id);
        GameDetailedResponse gameDetailedResponse = gameParaGameDetailedResponse(game);
        return ResponseEntity.ok(gameDetailedResponse);
    }

    @Override
    public ResponseEntity<GameDetailedResponse> atualizarGamePorId(UUID id, Map<String, Object> campos) {
        Game game = gameService.atualizarGame(id, campos);
        GameDetailedResponse gameDetailedResponse = gameParaGameDetailedResponse(game);
        return ResponseEntity.accepted().body(gameDetailedResponse);
    }

    @Override
    public ResponseEntity<Void> excluirGamePorId(UUID id) {
        gameService.excluirGame(id);
        return ResponseEntity.noContent().build();
    }

    private GameDetailedResponse gameParaGameDetailedResponse(Game game) {
        return mapper.convertValue(game, GameDetailedResponse.class);
    }
}
