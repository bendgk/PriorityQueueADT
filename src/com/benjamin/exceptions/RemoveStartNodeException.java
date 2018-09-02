package com.benjamin.exceptions;

/**
 * Exception that gets thrown when the root (start) node is attempted to be removed
 */
public class RemoveStartNodeException extends RuntimeException   {
    public RemoveStartNodeException(String message) {
        super(message);
    }
}
