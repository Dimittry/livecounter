package com.livecounter.exceptions;

@SuppressWarnings("serial")
public class EmailExistException extends RuntimeException {
    public EmailExistException(final String message) {
        super(message);
    }
}
