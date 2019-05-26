package com.org.rating.interfaces.service;

import com.org.rating.web.domain.AggregatedReview;
import com.org.rating.web.domain.Review;

public interface IProdRatingService {			
	public AggregatedReview getReviewRatings(String prodId);

	void editReviewRating(Review review);
}
