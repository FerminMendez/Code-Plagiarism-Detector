package com.renoux.gael.codejam.utils;


public class TechnicalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TechnicalException() {
        super();
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(Throwable cause) {
        super(cause);
    }

}
