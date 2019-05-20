package com.org.revrep.web.view.review;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.org.revrep.backend.domain.review.ReviewDAO;

@Component
public class ReviewInfoToReviewForm implements Converter<ReviewDAO, Review>{

	@Override
	public Review convert(ReviewDAO review) {
        Review reviewForm = new Review();
        reviewForm.setId(review.getId().toHexString());
        reviewForm.setProductId(review.getProductId());
        reviewForm.setUserId(review.getUserId());
        reviewForm.setDescription(review.getDescription());
        reviewForm.setRating(review.getRating());
        reviewForm.setTitle(review.getTitle());
        reviewForm.setCreationTime(review.getCreationTime());
        return reviewForm;
	}

}
