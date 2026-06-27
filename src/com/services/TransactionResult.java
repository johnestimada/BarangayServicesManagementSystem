package com.barangay.services;

public class TransactionResult<T> {
    private boolean success;
    private T data;
    private String message;

    public TransactionResult(boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

}

