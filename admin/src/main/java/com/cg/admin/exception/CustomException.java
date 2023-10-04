package com.cg.admin.exception;

import lombok.Data;

@Data
public class CustomException {
private String userMessage;
private String developerMessage;
private int statusCode;
}
