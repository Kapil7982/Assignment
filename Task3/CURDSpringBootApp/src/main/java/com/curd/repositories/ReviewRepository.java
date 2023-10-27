package com.curd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curd.models.Review;

/**
 * Repository interface for performing database operations on reviews.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}
