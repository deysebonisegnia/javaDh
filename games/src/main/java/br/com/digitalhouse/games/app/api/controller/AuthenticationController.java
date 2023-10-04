package br.com.digitalhouse.games.app.api.controller;

import br.com.digitalhouse.games.app.api.dto.request.AuthenticationSignInRequest;
import br.com.digitalhouse.games.app.api.dto.request.AuthenticationSignUpRequest;
import br.com.digitalhouse.games.app.api.dto.response.AuthenticationResponse;
import br.com.digitalhouse.games.domain.entity.SignIn;
import br.com.digitalhouse.games.domain.entity.SignUp;
import br.com.digitalhouse.games.domain.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping(value = "/sign-in")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid AuthenticationSignInRequest request) throws Exception{
        SignIn signIn = new SignIn(request.getEmail(), request.getPassword());
        String jwt = authenticationService.signIn(signIn);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody @Valid AuthenticationSignUpRequest request) throws Exception{
        SignUp signUp = SignUp.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .dataNascimento(request.getDataNascimento())
                .role(request.getRole())
                .build();
        String jwt = authenticationService.signUp(signUp);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AuthenticationResponse(jwt));
    }
}
