package com.login.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoginExceptionController {
	
	@ExceptionHandler(value = InvalidUserException.class)
	public ResponseEntity<ErrorMessageDTO> invalidUser(InvalidUserException exception) {
		return new ResponseEntity<>(new ErrorMessageDTO(401, "Invalid user"), HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(value = UserAlreadyExistException.class)
	public ResponseEntity<ErrorMessageDTO> userAlreadyExistException(UserAlreadyExistException exception) {
		return new ResponseEntity<>(new ErrorMessageDTO(400,"User Already Exist"), HttpStatus.BAD_REQUEST);
	}
}
