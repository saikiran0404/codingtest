package com.example.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ImagInnovateExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<FieldError> fields = ex.getFieldErrors();
		List<String> errorMessageList = new ArrayList<String>();
		for (FieldError error : fields) {
			System.out.println("Affected field of the object is: " + error.getDefaultMessage());
			errorMessageList.add(error.getDefaultMessage());
		}
		return new ResponseEntity<>(errorMessageList, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = DateOfBirthException.class)
	public ResponseEntity<Object> exception(DateOfBirthException ex) {
		return new ResponseEntity<>("Age should be between 15 to 20", HttpStatus.NOT_FOUND);
	}
}
