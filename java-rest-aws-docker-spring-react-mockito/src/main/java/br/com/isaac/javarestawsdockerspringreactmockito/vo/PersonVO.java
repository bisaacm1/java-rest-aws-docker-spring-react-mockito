package br.com.isaac.javarestawsdockerspringreactmockito.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@JsonPropertyOrder({ "id", "firstName", "lastName", "address", "gender" })
public class PersonVO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;

  @JsonProperty("address")
  private String address;

  @JsonProperty("gender")
  private String gender;
}