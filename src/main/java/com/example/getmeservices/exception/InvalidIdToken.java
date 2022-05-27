package com.example.getmeservices.exception;

public class InvalidIdToken extends Exception {

        @Override
        public String getMessage() {
            return "Invalid IdToken";
        }
    }
