package br.com.isaac.fiststepswithspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.isaac.fiststepswithspringboot.service.MathServiceImpl;

@RestController
public class MathController implements IMathController {

  private final MathServiceImpl service;

  public MathController(MathServiceImpl service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<Object> sum(@PathVariable String value1, @PathVariable String value2) {
    return ResponseEntity.ok(service.sum(value1, value2));
  }

  @Override
  public ResponseEntity<Object> subtraction(@PathVariable String value1, @PathVariable String value2) {
    return ResponseEntity.ok(service.subtraction(value1, value2));
  }

  @Override
  public ResponseEntity<Object> division(@PathVariable String value1, @PathVariable String value2) {
    return ResponseEntity.ok(service.division(value1, value2));
  }

  @Override
  public ResponseEntity<Object> average(@PathVariable String value1, @PathVariable String value2,
      @PathVariable String value3, @PathVariable String value4) {
    return ResponseEntity.ok(service.average(value1, value2, value3, value4));
  }

  @Override
  public ResponseEntity<Object> sqrt(@PathVariable String value1) {
    return ResponseEntity.ok(service.sqrt(value1));
  }

  @Override
  public ResponseEntity<Object> multiplication(@PathVariable String value1, @PathVariable String value2) {
    return ResponseEntity.ok(service.multiplication(value1, value2));
  }
}
