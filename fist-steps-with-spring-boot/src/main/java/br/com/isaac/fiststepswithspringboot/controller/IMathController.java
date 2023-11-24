package br.com.isaac.fiststepswithspringboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IMathController {

  @GetMapping(value = "/sum/{value1}/{value2}")
  public ResponseEntity<Object> sum(@PathVariable String value1, @PathVariable String value2);

  @GetMapping(value = "/subtraction/{value1}/{value2}")
  public ResponseEntity<Object> subtraction(@PathVariable String value1, @PathVariable String value2);

  @GetMapping(value = "/division/{value1}/{value2}")
  public ResponseEntity<Object> division(@PathVariable String value1, @PathVariable String value2);

  @GetMapping(value = "/average/{value1}/{value2}/{value3}/{value4}")
  public ResponseEntity<Object> average(@PathVariable String value1, @PathVariable String value2,
      @PathVariable String value3, @PathVariable String value4);

  @GetMapping(value = "/sqrt/{value1}")
  public ResponseEntity<Object> sqrt(@PathVariable String value1);

  @GetMapping(value = "/multiplication/{value1}/{value2}")
  public ResponseEntity<Object> multiplication(@PathVariable String value1, @PathVariable String value2);
}