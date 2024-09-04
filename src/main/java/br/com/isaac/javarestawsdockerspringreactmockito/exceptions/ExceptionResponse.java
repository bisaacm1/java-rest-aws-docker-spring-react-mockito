package br.com.isaac.javarestawsdockerspringreactmockito.exceptions;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse implements Serializable {
  private static final long serialVersionUID = 1L;
  private Date timestamp;
  private String message;
  private String details;
}
