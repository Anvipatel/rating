package com.org.rating.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.rating.interfaces.controller.IProdRatingController;
import com.org.rating.web.domain.AggregatedReview;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ratings")
public class ProductRatingManagement {
	
	@Autowired
	IProdRatingController reviewController;	
	
	@ApiOperation(value = "Used to get aggregated rating for input productId", response = AggregatedReview.class)
	@GetMapping("/{productId}")
	public AggregatedReview getReviewRatings(@PathVariable(value="productId") String productId) {
		return reviewController.getReviewRatings(productId);
	}

}
