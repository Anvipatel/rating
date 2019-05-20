package com.org.revrep.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.revrep.backend.domain.review.ReviewDAO;
import com.org.revrep.backend.service.ReviewService;
import com.org.revrep.web.view.review.Review;
import com.org.revrep.web.view.review.ReviewInfoToReviewForm;

/**
 * @author Anvi
 *
 */
@RestController
@RequestMapping("/review")
public class ReviewReporting {
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private ReviewInfoToReviewForm reviewInfoToReviewForm;

	@PostMapping	
	public ResponseEntity<Review> addNewReport(@RequestBody @Validated Review review) {
		ReviewDAO info = reviewService.addNewReport(review);
		reviewService.publishForNewReport(info);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(reviewInfoToReviewForm.convert(info));
	}
	@GetMapping
	public ResponseEntity<List<ReviewDAO>>	getReviews(@RequestParam(value="productId") String productId){
		List<ReviewDAO> reviewList = reviewService.getReviews(productId);		 
		return ResponseEntity.ok().body(reviewList);
	}
}
