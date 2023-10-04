package br.com.digitalhouse.games.app.api.dto.request;

import br.com.digitalhouse.games.domain.entity.UserPermissionEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class AuthenticationSignUpRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private UserPermissionEnum role;
}
