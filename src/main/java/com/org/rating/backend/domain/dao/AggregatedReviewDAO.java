package com.org.rating.backend.domain.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="AggregatedReview")
public class AggregatedReviewDAO implements IDomain {

	private static final long serialVersionUID = 1L;
	//private ObjectId id;
	@Id	
	private String productId;
	private double rating;
	private long no_of_reviews; //number of reviews
}
