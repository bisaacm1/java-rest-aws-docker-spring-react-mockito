package br.com.isaac.fiststepswithspringboot.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.isaac.fiststepswithspringboot.model.GreetingModel;

@RestController
public class GreetingController {
  private static final String template = "Hello, %s";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("greeting")
  public GreetingModel greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new GreetingModel(counter.incrementAndGet(), String.format(template, name));
  }
}
