package br.com.isaac.javarestawsdockerspringreactmockito.shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.isaac.javarestawsdockerspringreactmockito.shared.utils.Constants;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public RequiredObjectIsNullException() {
    super(Constants.NULL_OBJECT);
  }

  public RequiredObjectIsNullException(String string) {
    super(string);
  }
}
