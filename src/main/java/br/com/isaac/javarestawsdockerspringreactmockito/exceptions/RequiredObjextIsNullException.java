package br.com.isaac.javarestawsdockerspringreactmockito.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjextIsNullException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public RequiredObjextIsNullException() {
    super("It is not allowed to persist a null object!");
  }

  public RequiredObjextIsNullException(String string) {
    super(string);
  }
}
