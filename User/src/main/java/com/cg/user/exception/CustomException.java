package com.cg.user.exception;

import lombok.Data;

@Data
public class CustomException {
private String userMessage;
private String developerMessage;
private int statusCode;
}
