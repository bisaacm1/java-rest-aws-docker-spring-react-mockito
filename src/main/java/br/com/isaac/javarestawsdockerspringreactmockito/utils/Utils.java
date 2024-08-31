package br.com.isaac.javarestawsdockerspringreactmockito.utils;

import java.util.List;

public class Utils {
  public static String replaceCommaWithDot(String value) {
    return value.replaceAll(",", ".");
  }

  public static Double parseStringToDouble(String value) {
    return Double.parseDouble(replaceCommaWithDot(value));
  }

  public static Double sum(String value1, String value2) {
    Double valuePonto1 = parseStringToDouble(value1);
    Double valuePonto2 = parseStringToDouble(value2);

    return valuePonto1 + valuePonto2;
  }

  public static Double subtraction(String value1, String value2) {
    Double valuePonto1 = parseStringToDouble(value1);
    Double valuePonto2 = parseStringToDouble(value2);

    return valuePonto1 - valuePonto2;
  }

  public static Double division(String value1, String value2) {
    Double valuePonto1 = parseStringToDouble(value1);
    Double valuePonto2 = parseStringToDouble(value2);

    return valuePonto1 / valuePonto2;
  }

  public static Double average(String value1, String value2, String value3, String value4) {
    Double valuePonto1 = parseStringToDouble(value1);
    Double valuePonto2 = parseStringToDouble(value2);
    Double valuePonto3 = parseStringToDouble(value3);
    Double valuePonto4 = parseStringToDouble(value4);

    List<Double> valores = List.of(valuePonto1, valuePonto2, valuePonto3, valuePonto4);

    Double soma = 0.0;
    for (Double numero : valores) {
      soma += numero;
    }

    Double result = (double) soma / valores.size();

    return result;
  }

  public static Double sqrt(String value1) {
    Double valuePonto1 = parseStringToDouble(value1);

    return Math.sqrt(valuePonto1);
  }

  public static Double multiplication(String value1, String value2) {
    Double valuePonto1 = parseStringToDouble(value1);
    Double valuePonto2 = parseStringToDouble(value2);

    return valuePonto1 * valuePonto2;
  }
}
