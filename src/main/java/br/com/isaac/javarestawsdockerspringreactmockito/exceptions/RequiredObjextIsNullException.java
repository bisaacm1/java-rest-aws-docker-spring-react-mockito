package br.com.isaac.javarestawsdockerspringreactmockito.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.isaac.javarestawsdockerspringreactmockito.utils.Constants;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjextIsNullException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public RequiredObjextIsNullException() {
    super(Constants.NULL_OBJECT);
  }

  public RequiredObjextIsNullException(String string) {
    super(string);
  }
}
