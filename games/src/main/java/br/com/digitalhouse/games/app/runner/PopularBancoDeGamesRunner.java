package br.com.digitalhouse.games.app.runner;

import br.com.digitalhouse.games.domain.entity.Game;
import br.com.digitalhouse.games.domain.repository.GameRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Locale;

@Component
public class PopularBancoDeGamesRunner implements CommandLineRunner {
    private final GameRepository gameRepository;
    private final Faker faker;
    @Autowired
    public PopularBancoDeGamesRunner(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        faker = new Faker(new Locale("pt", "BR"));
    }

    @Override
    public void run(String... args) {
        Game gameOfThrones = new Game();
        gameOfThrones.setNome("casa em chamas %s".formatted(faker.gameOfThrones().house()));
        gameOfThrones.setGeneros(List.of("Dragões", "Drama", "Suspense"));
        gameOfThrones.setLancamento(LocalDate.of(2019, Month.AUGUST, 12));

        Game rickAndMorty = new Game();
        rickAndMorty.setNome("%s está em apuros!".formatted(faker.rickAndMorty().character()));
        rickAndMorty.setGeneros(List.of("comedia", "ação", "corrida"));
        gameOfThrones.setLancamento(LocalDate.of(2023, Month.JUNE, 16));

        Game gods = new Game();
        gods.setNome("God of war: %s em batalha".formatted(faker.ancient().god()));
        gods.setGeneros(List.of("luta", "guerra", "ação"));
        gods.setLancamento(LocalDate.of(1999, Month.APRIL, 3));

        Game chu = new Game();
        chu.setNome(faker.chuckNorris().fact());
        chu.setGeneros(List.of("luta", "batalha", "ação"));
        chu.setLancamento(LocalDate.of(2021, Month.DECEMBER, 25));

        Game aqua = new Game();
        aqua.setNome(faker.aquaTeenHungerForce().character());
        aqua.setLancamento(LocalDate.of(2013, Month.FEBRUARY, 20));
        aqua.setGeneros(List.of("Aqua Teen Hunger Force"));

        gameRepository.saveAll(List.of(gameOfThrones, rickAndMorty, gods, chu, aqua));
    }
}
