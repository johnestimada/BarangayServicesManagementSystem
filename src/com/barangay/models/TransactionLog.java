package com.barangay.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionLog {
    private String action;
    private LocalDateTime timestamp;

    public TransactionLog(String action) {
        this.action = action;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TransactionLog{action='" + action + "', timestamp=" + timestamp + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TransactionLog)) return false;
        TransactionLog other = (TransactionLog) o;
        return Objects.equals(action, other.action) && Objects.equals(timestamp, other.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, timestamp);
    }
}