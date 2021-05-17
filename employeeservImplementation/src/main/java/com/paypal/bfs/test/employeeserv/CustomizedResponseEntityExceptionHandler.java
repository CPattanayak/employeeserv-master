package com.paypal.bfs.test.employeeserv;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import com.paypal.bfs.test.employeeserv.customexception.EmployeeNotfoundException;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		if (body == null) 
			body = new HttpErrorWrapper(new Date(), ex, status);
		
		
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	@ExceptionHandler({Exception.class})
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		HttpErrorWrapper ew = new HttpErrorWrapper(new Date(), ex, HttpStatus.BAD_REQUEST);
		return handleExceptionInternal(ex, ew, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult result = ex.getBindingResult();
        List<org.springframework.validation.FieldError> fieldErrors = result.getFieldErrors();
        ValidationError ew = processFieldErrors(fieldErrors);
		return handleExceptionInternal(ex, ew, headers, HttpStatus.BAD_REQUEST, request);
	}
	 
	 @ExceptionHandler(EmployeeNotfoundException.class)
	  public final ResponseEntity<Object> handleUserNotFoundException(EmployeeNotfoundException ex, WebRequest request) {
		 HttpErrorWrapper ew = new HttpErrorWrapper(new Date(), ex, HttpStatus.NOT_FOUND);
			return handleExceptionInternal(ex, ew, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	  }
	 private ValidationError processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
		 ValidationError error = new ValidationError(BAD_REQUEST.value(), "validation error");
	        for (org.springframework.validation.FieldError fieldError: fieldErrors) {
	            error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
	        }
	        return error;
	    }
	   

}
