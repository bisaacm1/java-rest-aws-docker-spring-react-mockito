package br.com.isaac.fiststepswithspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.isaac.fiststepswithspringboot.service.MathServiceImpl;

@RestController
public class MathController implements IMathController {

  private final MathServiceImpl service;

  public MathController(MathServiceImpl service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<Object> sum(String value1, String value2) {
    return ResponseEntity.ok(service.sum(value1, value2));
  }

  @Override
  public ResponseEntity<Object> subtraction(String value1, String value2) {
    return ResponseEntity.ok(service.subtraction(value1, value2));
  }

  @Override
  public ResponseEntity<Object> division(String value1, String value2) {
    return ResponseEntity.ok(service.division(value1, value2));
  }

  @Override
  public ResponseEntity<Object> average(String value1, String value2,
      String value3, String value4) {
    return ResponseEntity.ok(service.average(value1, value2, value3, value4));
  }

  @Override
  public ResponseEntity<Object> sqrt(String value1) {
    return ResponseEntity.ok(service.sqrt(value1));
  }

  @Override
  public ResponseEntity<Object> multiplication(String value1, String value2) {
    return ResponseEntity.ok(service.multiplication(value1, value2));
  }
}
