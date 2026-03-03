package com.lpu.employeeApp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ArithmeticException.class)
	// public Map<String, String> handleArithmeticEx(ArithmeticException ex){ //OR
	// so that you get required error and not 200 ok
	public ResponseEntity<Map<String, String>> handleArithmeticEx(ArithmeticException ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
	}
	
	// 404 Not found
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleCompanyNotFoundException(CompanyNotFoundException ex) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}

//	public Map<String, String> handleCompanyNotFoundException(CompanyNotFoundException ex){
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("Error", ex.getMessage());
//		return map;
//	}
	
	// 400 bad request
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors().forEach(error -> map.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
//		Map<String, String> map = new HashMap<String, String>();
//		ex.getBindingResult().getFieldErrors().forEach(error-> map.put(error.getField(), error.getDefaultMessage()));
//		return map;
//	}
	
	// 500 internal error
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleAllException(Exception ex) {
		Map<String, String> map = new HashMap<>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
	}

//	@ExceptionHandler(Exception.class)
//	public Map<String, String> handleAllException(Exception ex){
//		Map<String, String> map = new HashMap<>();
//		map.put("Error", ex.getMessage());
//		return map;
//	}
}
