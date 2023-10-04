package br.com.digitalhouse.games.domain.service;

import br.com.digitalhouse.games.domain.entity.SignIn;
import br.com.digitalhouse.games.domain.entity.SignUp;

public interface AuthenticationService {
    String signIn(SignIn request);

    String signUp(SignUp request);
}
