package com.bookManagement.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookManagement.exception.ResourceNotFoundException;
import com.bookManagement.model.Book;
import com.bookManagement.model.Customer;
import com.bookManagement.model.Order;
import com.bookManagement.model.OrderItem;
import com.bookManagement.model.OrderItemRequest;
import com.bookManagement.model.PlaceOrderRequest;
import com.bookManagement.repository.BookRepository;
import com.bookManagement.repository.CustomerRepository;
import com.bookManagement.repository.OrderRepository;
	
@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;
	
    @Autowired
    private CustomerRepository userRepository;
    
    @Autowired
    private BookRepository bookRepository;

    public Order placeOrder(PlaceOrderRequest request) {
    	Customer user = userRepository.findByUsername(request.getUsername())
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
    	List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;
        
        for (OrderItemRequest itemRequest : request.getItems()) {
            Book book = bookRepository.findById(itemRequest.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));
            
            if (book.getStockQuantity() < itemRequest.getQuantity()) {
                throw new IllegalStateException("Not enough stock for book: " + book.getTitle());
            }
            
            
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(book);
            orderItem.setQuantity(itemRequest.getQuantity());
            orderItem.setPrice(book.getPrice().multiply(BigDecimal.valueOf(itemRequest.getQuantity())));
            orderItems.add(orderItem);
            
            totalPrice = totalPrice.add(orderItem.getPrice());
            
            book.setStockQuantity(book.getStockQuantity() - itemRequest.getQuantity());
            bookRepository.save(book);
        }
        
        Order order = new Order();
        order.setCustomer(user);
        order.setOrderItems(orderItems);
        order.setStatus("PLACED");
        order.setOrderDate(LocalDateTime.now());
        order.setTotalPrice(totalPrice);
        
        return orderRepository.save(order);
    }
    
    public List<Order> getUserOrderHistory(String username) {
    	Customer user = userRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        return orderRepository.findByCustomer(user);
    }
}
