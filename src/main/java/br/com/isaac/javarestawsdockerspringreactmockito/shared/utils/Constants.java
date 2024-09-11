package br.com.isaac.javarestawsdockerspringreactmockito.shared.utils;

public class Constants {

  // Error Messages
  public static final String VALUE_SHOULD_BE_NUMBER = "The value must be a number";
  public static final String INTERNAL_ERROR = "Internal server error";
  public static final String UNSUPPORTED_OPERATION = "Unsupported math operation";
  public static final String NULL_OBJECT = "Persisting a null object is not allowed!";
  public static final String ID_NOT_FOUND = "No records found for this ID: ";

  // Response Descriptions
  public static final String SUCCESS = "Success";
  public static final String BAD_REQUEST = "Bad Request";
  public static final String UNAUTHORIZED = "Unauthorized";
  public static final String NOT_FOUND = "Not Found";
  public static final String NO_CONTENT = "No Content";
  public static final String CREATED = "Created"; // For successful creation

  // Media Types
  public static final String APPLICATION_JSON = "application/json";
  public static final String APPLICATION_XML = "application/xml";
  public static final String APPLICATION_YML = "application/x-yaml";
  public static final String JSON = "json";
  public static final String XML = "xml";
  public static final String X_YAML = "x-yaml";

  // HTTP Response Codes
  public static final String RESPONSE_CODE_OK = "200";
  public static final String RESPONSE_CODE_CREATED = "201";
  public static final String RESPONSE_CODE_NO_CONTENT = "204";
  public static final String RESPONSE_CODE_BAD_REQUEST = "400";
  public static final String RESPONSE_CODE_UNAUTHORIZED = "401";
  public static final String RESPONSE_CODE_NOT_FOUND = "404";
  public static final String RESPONSE_CODE_INTERNAL_ERROR = "500";

  // HTTP Headers
  public static final String HEADER_PARAM_AUTHORIZATION = "Authorization";
  public static final String HEADER_PARAM_ORIGIN = "Origin";

  // Origins
  public static final String ORIGIN_ISAAC = "https://br.com.isaac";
  public static final String ORIGIN_ISAAC_TEST_FAIL = "https://br.com.isaac.testfail";
  public static final String ORIGIN_LOCALHOST_3000 = "http://localhost:3000";
  public static final String ORIGIN_LOCALHOST_8080 = "http://localhost:8080";

  // Server Configurations
  public static final int SERVER_PORT = 8888;
}
