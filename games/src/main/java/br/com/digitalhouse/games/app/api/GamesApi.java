package br.com.digitalhouse.games.app.api;

import br.com.digitalhouse.games.app.api.dto.request.CreateGameRequest;
import br.com.digitalhouse.games.app.api.dto.response.GameDetailedResponse;
import br.com.digitalhouse.games.app.api.dto.response.GameSummaryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/games")
public interface GamesApi {

    @GetMapping
    ResponseEntity<Page<GameSummaryResponse>> buscarGames(@PageableDefault Pageable page);

    @PostMapping
    ResponseEntity<GameDetailedResponse> criarGame(@RequestBody @Valid CreateGameRequest request);

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('USER')")
    ResponseEntity<GameDetailedResponse> buscarGamePorId(@PathVariable UUID id);

    @PatchMapping("{id}")
    ResponseEntity<GameDetailedResponse> atualizarGamePorId(@PathVariable UUID id, Map<String, Object> campos);

    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirGamePorId(@PathVariable UUID id);

}
