package com.curd.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.curd.models.Product;
import com.curd.models.Review;
import com.curd.repositories.ProductRepository;
import com.curd.repositories.ReviewRepository;
import com.curd.services.ReviewServiceImpl;

public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ReviewServiceImpl reviewService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddReview() {
        Product  product = new Product(1L, "Product A", 29.99, null, null, null);
        Review reviewToAdd = new Review(null, "user123", "This product is great!", null, null, product);

        Review reviewAdded = new Review(1L, "user123", "This product is great!", LocalDateTime.now(), LocalDateTime.now(), product);

        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(reviewRepository.save(any(Review.class))).thenReturn(reviewAdded);

        Review result = reviewService.addReview(1L, reviewToAdd);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("user123", result.getUserId());
        assertEquals("This product is great!", result.getDescription());
    }
    
    @Test
    public void testDeleteReview() {
        // Assuming that review with ID 1 exists
        doNothing().when(reviewRepository).deleteById(1L);

        reviewService.deleteReview(1L, 1L);

        // Verify that the delete method is called with the correct ID
        verify(reviewRepository, times(1)).deleteById(1L);
    }

    
}
