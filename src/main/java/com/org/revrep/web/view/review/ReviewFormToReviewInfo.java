package com.org.revrep.web.view.review;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.org.revrep.backend.domain.review.ReviewDAO;

@Component
public class ReviewFormToReviewInfo implements Converter<Review, ReviewDAO>{
    @Override
    public ReviewDAO convert(Review reviewForm) {
        ReviewDAO review = new ReviewDAO();
        if (reviewForm.getId() != null  && !StringUtils.isEmpty(reviewForm.getId())) {
            review.setId(new ObjectId(reviewForm.getId()));
        }
        review.setProductId(reviewForm.getProductId());
        review.setUserId(reviewForm.getUserId());
        review.setTitle(reviewForm.getTitle());
        review.setDescription(reviewForm.getDescription());        
        review.setRating(reviewForm.getRating());
        review.setCreationTime(new Date());
        return review;
    }
}
