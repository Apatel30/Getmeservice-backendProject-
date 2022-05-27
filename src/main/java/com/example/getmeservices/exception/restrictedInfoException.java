package com.example.getmeservices.exception;

public class restrictedInfoException extends Exception{
    @Override
    public String getMessage() {

        return "Classified information...";
    }

}


