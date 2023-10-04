package br.com.digitalhouse.games.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignIn {
    private String email;
    private String password;
}
