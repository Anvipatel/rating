package com.org.rating.interfaces.controller;

import org.springframework.web.bind.annotation.RequestParam;

import com.org.rating.web.domain.AggregatedReview;

public interface IProdRatingController {
	public AggregatedReview getReviewRatings(@RequestParam(value="productId") String productId);
}
