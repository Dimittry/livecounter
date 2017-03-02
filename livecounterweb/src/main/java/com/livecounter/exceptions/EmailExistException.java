package com.livecounter.exceptions;

@SuppressWarnings("serial")
public class EmailExistException extends Throwable {
    public EmailExistException(final String message) {
        super(message);
    }
}
