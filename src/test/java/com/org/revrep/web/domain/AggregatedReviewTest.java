package com.org.revrep.web.domain;

import com.org.rating.backend.domain.dao.IDomain;

import lombok.Data;

@Data
public class AggregatedReviewTest implements IDomain{
	private static final long serialVersionUID = 1L;
	private String productId;
	private double rating;
	private long no_of_reviews;
}
