package org.example.booksapp.customException;

public class ValidException extends RuntimeException {
  public ValidException(){
    super("The data was entered incorrectly!");
  }

  public ValidException(String message) {
    super(message);
  }
}
