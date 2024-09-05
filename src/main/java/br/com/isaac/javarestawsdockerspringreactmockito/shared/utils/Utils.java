package br.com.isaac.javarestawsdockerspringreactmockito.shared.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {

  public interface Loggable {
    default Logger getLogger() {
      return LoggerFactory.getLogger(getClass());
    }
  }

}
