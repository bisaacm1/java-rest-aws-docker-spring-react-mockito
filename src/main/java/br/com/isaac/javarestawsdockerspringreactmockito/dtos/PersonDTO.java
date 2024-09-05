package br.com.isaac.javarestawsdockerspringreactmockito.dtos;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({ "key", "firstName", "lastName", "address", "gender" })
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long key;

  @JsonProperty("first_name")
  private String firstName;

  @JsonProperty("last_name")
  private String lastName;

  @JsonProperty("address")
  private String address;

  @JsonProperty("gender")
  private String gender;
}