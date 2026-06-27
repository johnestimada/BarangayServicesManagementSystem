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

    public boolean isSuccess() { return success; }
    public T getData() { return data; }
    public String getMessage() { return message; }

    @Override
    public String toString() {
        return "TransactionResult{" +
                "success=" + success +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}

