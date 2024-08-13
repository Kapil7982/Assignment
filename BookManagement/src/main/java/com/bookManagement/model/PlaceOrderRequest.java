package com.bookManagement.model;

import java.util.List;

public class PlaceOrderRequest {
 private String username;
 private List<OrderItemRequest> items;

 // Getters and setters

 public String getUsername() {
     return username;
 }

 public void setUsername(String username) {
     this.username = username;
 }

 public List<OrderItemRequest> getItems() {
     return items;
 }

 public void setItems(List<OrderItemRequest> items) {
     this.items = items;
 }
}
