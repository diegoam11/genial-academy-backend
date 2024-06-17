package com.diegodev.backendgenialacademy.exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String msg) {super(msg);}
}
