package br.com.digitalhouse.games;

import br.com.digitalhouse.games.app.api.dto.request.CreateGameRequest;
import br.com.digitalhouse.games.domain.entity.Game;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class Fixture {

    private static final Faker FAKER = new Faker(new Locale("pt", "BR"));

    public static class GameFake {
        public static CreateGameRequest anyGame() {
            CreateGameRequest game = new CreateGameRequest();
            game.setNome(FAKER.rickAndMorty().character());
            game.setLancamento(LocalDate.ofInstant(FAKER.date().birthday().toInstant(), ZoneId.systemDefault()));
            game.setGenero(List.of(FAKER.options()
                    .option("ação", "drama", "suspense", "intriga", "baseados na nazare")));
            return game;
        }
    }
}
