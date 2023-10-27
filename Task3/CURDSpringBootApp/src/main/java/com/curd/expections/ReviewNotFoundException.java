package com.curd.expections;

/**
 * Custom exception thrown when a review is not found.
 */
public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
