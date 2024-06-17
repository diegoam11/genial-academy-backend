package com.diegodev.backendgenialacademy.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Error {
    private String message;
    private int status;
    private Date date;
}
