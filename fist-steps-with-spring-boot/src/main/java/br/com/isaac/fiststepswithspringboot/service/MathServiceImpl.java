package br.com.isaac.fiststepswithspringboot.service;

import org.springframework.http.ResponseEntity;

public interface MathServiceImpl {

  ResponseEntity<Object> sum(String value1, String value2);

  ResponseEntity<Object> subtraction(String value1, String value2);

  ResponseEntity<Object> division(String value1, String value2);

  ResponseEntity<Object> average(String value1, String value2, String value3, String value4);

  ResponseEntity<Object> sqrt(String value1);

  ResponseEntity<Object> multiplication(String value1, String value2);

}
