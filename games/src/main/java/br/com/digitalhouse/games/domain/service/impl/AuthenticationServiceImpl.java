package br.com.digitalhouse.games.domain.service.impl;

import br.com.digitalhouse.games.domain.entity.SignIn;
import br.com.digitalhouse.games.domain.entity.SignUp;
import br.com.digitalhouse.games.domain.entity.UserDetail;
import br.com.digitalhouse.games.domain.repository.UserRepository;
import br.com.digitalhouse.games.domain.service.AuthenticationService;
import br.com.digitalhouse.games.domain.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public String signUp(SignUp request) {
        var user = UserDetail.builder().nome(request.getNome())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole()).build();
        userRepository.save(user);
        return jwtService.generateToken(user);

    }

    @Override
    public String signIn(SignIn request) {
        var authentication = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        authenticationManager.authenticate(authentication);
        var user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        return jwtService.generateToken(user);
    }
}