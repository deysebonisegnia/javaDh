package br.com.digitalhouse.games;

import br.com.digitalhouse.games.app.api.dto.request.CreateGameRequest;
import br.com.digitalhouse.games.domain.entity.Game;
import br.com.digitalhouse.games.domain.service.GameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class GamesApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @SpyBean
    private GameService gameService;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(mvc);
    }

    @Test
    void dado5RegistrosNoBanco_quandoChamamosEndpointBuscarGames_entaoRetornarRegistrosPaginados() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/v1/games")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalElements", equalTo(5)))
                .andExpect(jsonPath("$", hasKey("size")));
    }

    @Test
    void dado5RegistrosNoBanco_quandoChamamosEndpointBuscarGamesCom2Elementos_entaoRetornar2ElementosNoConteudo() throws Exception {
        Mockito.when(gameService.buscarGames(Mockito.any()))
                .thenReturn(new PageImpl<>(List.<Game>of()));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/v1/games?size=2")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(2)))
                .andExpect(jsonPath("$.totalElements", equalTo(5)))
                .andExpect(jsonPath("$", hasKey("size")));
    }

    @Test
    void dadaListaVazia_quandoChamamosEndpointBuscarGamesCom5Elementos_entaoRetornarPaginaVaziaa() throws Exception {
        Mockito.when(gameService.buscarGames(Mockito.any()))
                .thenReturn(new PageImpl<>(List.of()));

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/v1/games")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(0)))
                .andExpect(jsonPath("$.totalElements", equalTo(0)))
                .andExpect(jsonPath("$", hasKey("size")));
    }

    @Test
    void dadoUmObjetoValido_quandoChamamosCriarGame_entaoRetornarObjetoMockado() throws Exception {
        CreateGameRequest game = Fixture.GameFake.anyGame();

        String gameAsJson = mapper.writeValueAsString(game);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/v1/games")
                .content(gameAsJson)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
