package org.example.booksapp.customexception;

public class ValidException extends RuntimeException {
  public ValidException(){
    super("The data was entered incorrectly!");
  }

  public ValidException(String message) {
    super(message);
  }
}
