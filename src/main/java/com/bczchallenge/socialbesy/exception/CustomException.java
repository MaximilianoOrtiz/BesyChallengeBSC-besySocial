package com.bczchallenge.socialbesy.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class CustomException {
    private CustomException() {
    }

    public static class ImplementationCustomExceptions extends Exception{
        public String mensaje;
        public ImplementationCustomExceptions(String message,Throwable cause){
            super (cause);
            this.mensaje= message;

        }
    }


}
