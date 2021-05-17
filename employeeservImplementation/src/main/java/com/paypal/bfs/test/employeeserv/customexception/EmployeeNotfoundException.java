package com.paypal.bfs.test.employeeserv.customexception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotfoundException extends RuntimeException {

	  public EmployeeNotfoundException(String exception) {
	    super(exception);
	  }

	}
