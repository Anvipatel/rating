package com.org.revrep.backend.domain.review;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class ReviewAggregatorDAO implements IDomain {
	
	//private ObjectId id;
	@Id	
	private String productId;
	private double rating;
	private long count; //number of reviews
}
