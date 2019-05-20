package com.org.revrep.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.org.revrep.backend.domain.review.ReviewAggregatorDAO;

public interface ReviewAggregatorRepo extends CrudRepository<ReviewAggregatorDAO, String>{

}
