package com.bczchallenge.socialbesy.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class CustomException {
    private CustomException() {
    }

    public static class ImplementationCustomExceptions extends Exception{
        public ImplementationCustomExceptions(Throwable cause){
            super (cause);

        }
    }


}
