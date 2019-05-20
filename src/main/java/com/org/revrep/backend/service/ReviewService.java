package com.org.revrep.backend.service;

import java.util.List;

import com.org.revrep.backend.domain.review.ReviewDAO;
import com.org.revrep.web.view.review.Review;

public interface ReviewService {

	ReviewDAO addNewReport(Review addInfo);

	void publishForNewReport(ReviewDAO info);
	
	List<ReviewDAO> getReviews(String prodId);

	ReviewDAO saveOrUpdate(ReviewDAO review);

	ReviewDAO saveOrUpdateProductForm(Review reviewForm);
} 
