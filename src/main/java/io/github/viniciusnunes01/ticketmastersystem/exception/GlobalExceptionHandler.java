package io.github.viniciusnunes01.ticketmastersystem.exception;

import io.github.viniciusnunes01.ticketmastersystem.dto.ValidacaoErroDTO;
import jakarta.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidacaoErroDTO> tratarErroValidacao(MethodArgumentNotValidException ex) {
        
        ValidacaoErroDTO erroDTO = new ValidacaoErroDTO();
        erroDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        erroDTO.setMensagem("Erro de validação nos dados enviados");

        
        ex.getBindingResult().getFieldErrors().forEach(erro -> {
            erroDTO.adicionarErro(erro.getField(), erro.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erroDTO);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(RuntimeException e, HttpServletRequest request) {

		var status = HttpStatus.NOT_FOUND;

		StandardError error = new StandardError(LocalDateTime.now(), status, "Recurso não encontrado.", e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(error);
	}
}