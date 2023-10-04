package br.com.digitalhouse.games.domain.service.impl;

import br.com.digitalhouse.games.domain.entity.Game;
import br.com.digitalhouse.games.domain.exception.GameNotFoundException;
import br.com.digitalhouse.games.domain.repository.GameRepository;
import br.com.digitalhouse.games.domain.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Page<Game> buscarGames(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    @Override
    public Game buscarPorId(UUID id) {
        return gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
    }

    @Override
    public Game criarGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game atualizarGame(UUID id, Map<String, Object> campos) {
        return null;
    }

    @Override
    public void excluirGame(UUID id) {
        Game game = gameRepository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
        gameRepository.delete(game);
    }
}
