package com.eduardo.core.exception;

public class AuthenticationException extends RuntimeException {

  private String code;

  public AuthenticationException(String message, String code) {
    super(message);
    this.code = code;
  }
}
