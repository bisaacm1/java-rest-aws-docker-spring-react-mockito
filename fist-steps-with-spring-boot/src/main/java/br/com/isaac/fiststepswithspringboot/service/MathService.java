package br.com.isaac.fiststepswithspringboot.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.isaac.fiststepswithspringboot.exceptions.UnsuportedMathOperationException;
import br.com.isaac.fiststepswithspringboot.utils.EnumMessagesType;
import br.com.isaac.fiststepswithspringboot.utils.Utils;

@Service
public class MathService implements MathServiceImpl {

  @Override
  public ResponseEntity<Object> sum(String value1, String value2) {
    return performOperation(value1, value2, Utils::sum);
  }

  @Override
  public ResponseEntity<Object> subtraction(String value1, String value2) {
    return performOperation(value1, value2, Utils::subtraction);
  }

  @Override
  public ResponseEntity<Object> division(String value1, String value2) {
    return performOperation(value1, value2, Utils::division);
  }

  @Override
  public ResponseEntity<Object> multiplication(String value1, String value2) {
    return performOperation(value1, value2, Utils::multiplication);
  }

  @Override
  public ResponseEntity<Object> average(String value1, String value2, String value3, String value4) {
    try {
      Double result = Utils.average(value1, value2, value3, value4);
      return ResponseEntity.ok(result);
    } catch (NumberFormatException e) {
      throw new UnsuportedMathOperationException(EnumMessagesType.VALUE_SHOULD_BE_NUMBER.getMessage());
    }
  }

  @Override
  public ResponseEntity<Object> sqrt(String value1) {
    try {
      Double result = Utils.sqrt(value1);
      return ResponseEntity.ok(result);
    } catch (NumberFormatException e) {
      throw new UnsuportedMathOperationException(EnumMessagesType.VALUE_SHOULD_BE_NUMBER.getMessage());
    }
  }

  private interface MathOperation {
    Double operate(String value1, String value2);
  }

  private ResponseEntity<Object> performOperation(String value1, String value2, MathOperation operation) {
    try {
      Double result = operation.operate(value1, value2);
      return ResponseEntity.ok(result);
    } catch (NumberFormatException e) {
      throw new UnsuportedMathOperationException(EnumMessagesType.VALUE_SHOULD_BE_NUMBER.getMessage());
    }
  }
}
