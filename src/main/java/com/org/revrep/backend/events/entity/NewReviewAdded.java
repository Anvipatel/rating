package com.org.revrep.backend.events.entity;

import com.org.revrep.backend.domain.review.ReviewDAO;

/**
 * @author Anvi P
 */
public class NewReviewAdded {

	public static final String EVENT_NAME = "NewReviewAdded";

	private final ReviewDAO   reviewInfo;

	public NewReviewAdded(ReviewDAO info) {
		this.reviewInfo = info;
	}

	public String event() {
		return EVENT_NAME;
	}

	public ReviewDAO getReviewInfo() {
		return reviewInfo;
	}

}
