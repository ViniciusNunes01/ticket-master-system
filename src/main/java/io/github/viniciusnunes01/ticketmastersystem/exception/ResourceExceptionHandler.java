package io.github.viniciusnunes01.ticketmastersystem.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<StandardError> error(IllegalArgumentException e, HttpServletRequest request) {

		var status = HttpStatus.BAD_REQUEST;

		StandardError error = new StandardError(LocalDateTime.now(), status, "Erro de Validação.", e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(error);

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(RuntimeException e, HttpServletRequest request) {

		var status = HttpStatus.NOT_FOUND;

		StandardError error = new StandardError(LocalDateTime.now(), status, "Recurso não encontrado.", e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(error);
	}
}
