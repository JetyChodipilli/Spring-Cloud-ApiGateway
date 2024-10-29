package com.jt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee-api")
public class EmployeeOperations {
	@GetMapping("/report")
	public ResponseEntity<String> showMessage(){
		return new ResponseEntity<String>("From Employee operations", HttpStatus.OK);
	}

}
