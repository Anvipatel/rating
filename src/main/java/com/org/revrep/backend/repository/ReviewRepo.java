package com.org.revrep.backend.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.org.revrep.backend.domain.review.ReviewDAO;
import com.org.revrep.web.view.review.Review;

@Component
public interface ReviewRepo extends PagingAndSortingRepository<ReviewDAO, String> {
	List<ReviewDAO> findByProductId(String productId);
}
