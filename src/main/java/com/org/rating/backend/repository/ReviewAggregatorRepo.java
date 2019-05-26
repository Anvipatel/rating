package com.org.rating.backend.repository;

import org.springframework.data.repository.CrudRepository;

import com.org.rating.backend.domain.dao.AggregatedReviewDAO;

public interface ReviewAggregatorRepo extends CrudRepository<AggregatedReviewDAO, String>{

}
