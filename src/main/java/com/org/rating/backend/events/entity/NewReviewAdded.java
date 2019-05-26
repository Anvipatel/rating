package com.org.rating.backend.events.entity;

import com.org.rating.web.domain.Review;


public class NewReviewAdded {
	
	public NewReviewAdded(){}
	
	public static final String EVENT_NAME = "NewReviewAddedEvent";

	private Review   reviewInfo;

	public NewReviewAdded(Review review) {
		this.reviewInfo = review;
	}

	public String event() {
		return EVENT_NAME;
	}

	public Review getReviewInfo() {
		return reviewInfo;
	}

}
