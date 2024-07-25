package com.ait.vision.exceptionhandling.exeption;

public class SupplierAlreadyExistsException extends RuntimeException{

    public SupplierAlreadyExistsException() {
    }

    public SupplierAlreadyExistsException(String message) {
        super(message);
    }
}
