package io.github.viniciusnunes01.ticketmastersystem.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class StandardError {

	private LocalDateTime timeStampError;
	private HttpStatus statusError;
	private String nameError;
	private String messageError;
	private String pathError;

	public StandardError(LocalDateTime timeStampError, HttpStatus statusError, String nameError, String messageError,
			String pathError) {
		super();
		this.timeStampError = timeStampError;
		this.statusError = statusError;
		this.nameError = nameError;
		this.messageError = messageError;
		this.pathError = pathError;
	}

	public LocalDateTime getTimeStampError() {
		return timeStampError;
	}

	public void setTimeStampError(LocalDateTime timeStampError) {
		this.timeStampError = timeStampError;
	}

	public HttpStatus getStatusError() {
		return statusError;
	}

	public void setStatusError(HttpStatus statusError) {
		this.statusError = statusError;
	}

	public String getNameError() {
		return nameError;
	}

	public void setNameError(String nameError) {
		this.nameError = nameError;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

	public String getPathError() {
		return pathError;
	}

	public void setPathError(String pathError) {
		this.pathError = pathError;
	}

}
