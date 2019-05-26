package com.org.rating.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.rating.interfaces.controller.IProdRatingController;
import com.org.rating.web.domain.AggregatedReview;

@RestController
@RequestMapping("/ratings")
public class ProductRatingManagement {
	
	@Autowired
	IProdRatingController reviewController;	
	
	@GetMapping("/{productId}")
	public AggregatedReview getReviewRatings(@PathVariable(value="productId") String productId) {
		return reviewController.getReviewRatings(productId);
	}

}
