package com.benjamin.exceptions;

public class EmptyPriorityQueueException extends RuntimeException {
    public EmptyPriorityQueueException(String message) {
        super(message);
    }
}
