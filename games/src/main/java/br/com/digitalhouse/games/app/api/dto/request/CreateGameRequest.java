package br.com.digitalhouse.games.app.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CreateGameRequest {

    @NotBlank // null and blank == nome = null; nome = "                  ";
    private String nome;
    @NotNull
    private LocalDate lancamento;
    @NotEmpty
    private List<String> genero;

}
