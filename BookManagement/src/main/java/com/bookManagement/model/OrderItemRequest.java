package com.bookManagement.model;

public class OrderItemRequest {
    private Long bookId;
    private Integer quantity;

    // Getters and setters

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
