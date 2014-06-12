package com.iut.bank.exceptions;

/**
 * Created by schuma on 30/05/14.
 */
public class BankException extends Exception{
    private static final long serialVersionUID = 2000L;

    private boolean businessError;
    private boolean technicalError;
    private String message;

    public boolean isBusinessError() {
        return businessError;
    }

    public boolean isTechnicalError() {
        return technicalError;
    }

    public String getMessage() {
        return message;
    }

    /***
     * Create specific Exception for bank :
     * @param message
     * @param businessError
     * @param technicalError
     * @param e
     */
    public BankException(String message, boolean businessError, boolean technicalError, Exception e) {
        super();
        this.message = message;
        this.businessError = businessError;
        this.technicalError = technicalError;
        if (businessError)
            System.out.println("Business Error = " + message);
        if (technicalError)
            System.out.println("Technical Error = " + message);
    }
}
