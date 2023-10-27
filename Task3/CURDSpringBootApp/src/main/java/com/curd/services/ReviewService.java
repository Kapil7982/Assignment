package com.curd.services;

import com.curd.models.Review;

public interface ReviewService {

	public Review addReview(Long productId, Review review);
	public void deleteReview(Long productId, Long reviewId);
}
