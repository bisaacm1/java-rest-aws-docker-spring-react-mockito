package br.com.isaac.fiststepswithspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GreetingModel {
  private final long id;
  private final String content;

}
