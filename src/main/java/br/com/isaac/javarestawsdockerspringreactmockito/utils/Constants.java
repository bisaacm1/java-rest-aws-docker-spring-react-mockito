package br.com.isaac.javarestawsdockerspringreactmockito.utils;

public class Constants {
  // Error messages
  public static final String VALUE_SHOULD_BE_NUMBER = "The value needs to be a number";
  public static final String INTERNAL_ERROR = "Internal server error";
  public static final String UNSUPPORTED_OPERATION = "Unsupported math operation error";
  public static final String NULL_OBJECT = "It is not allowed to persist a null object!";
  public static final String ID_NOT_FOUND = "No records found for this id: ";

  // Response descriptions
  public static final String SUCCESS = "Success";
  public static final String BAD_REQUEST = "Bad Request";
  public static final String UNAUTHORIZED = "Unauthorized";
  public static final String NOT_FOUND = "Not Found";
  public static final String NO_CONTENT = "No Content";

  // Media Types
  public static final String APPLICATION_JSON = "application/json";
  public static final String APPLICATION_XML = "application/xml";
  public static final String APPLICATION_YML = "application/x-yaml";
  public static final String JSON = "json";
  public static final String XML = "xml";
  public static final String X_YAML = "x-yaml";

  // HTTP Response Codes
  public static final String RESPONSE_CODE_OK = "200";
  public static final String RESPONSE_CODE_NO_CONTENT = "204";
  public static final String RESPONSE_CODE_BAD_REQUEST = "400";
  public static final String RESPONSE_CODE_UNAUTHORIZED = "401";
  public static final String RESPONSE_CODE_NOT_FOUND = "404";
  public static final String RESPONSE_CODE_INTERNAL_ERROR = "500";
}
