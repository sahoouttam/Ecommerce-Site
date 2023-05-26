package com.portal.inventoryservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ErrorMessage {

    private int statusCode;
    private Date timeStamp;
    private String message;
    private String description;
}
