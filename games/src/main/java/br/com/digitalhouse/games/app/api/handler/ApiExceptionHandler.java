package br.com.digitalhouse.games.app.api.handler;

import br.com.digitalhouse.games.domain.exception.GameNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<?> gameNotFoundExceptionHandler(GameNotFoundException exception) {
        return ResponseEntity.badRequest().body(
                """
                {
                    "status" : 400,
                    "message" : "%s"
                }       \s
                """.formatted(exception.getMessage())
        );
    }

}
