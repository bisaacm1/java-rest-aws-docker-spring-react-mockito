package br.com.isaac.javarestawsdockerspringreactmockito.vo;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PersonVO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String firstName;
  private String lastName;
  private String address;
  private String gender;
}