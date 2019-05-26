package com.org.rating.backend.domain.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.org.rating.backend.domain.dao.AggregatedReviewDAO;
import com.org.rating.web.domain.AggregatedReview;

@Component
public class ReviewAggDaoToAggregatedReview implements Converter<AggregatedReviewDAO, AggregatedReview> {

	@Override
	public AggregatedReview convert(AggregatedReviewDAO daoObj) {
		AggregatedReview domainObj = new AggregatedReview();
		domainObj.setProductId(daoObj.getProductId());
		domainObj.setRating(daoObj.getRating());
		domainObj.setNo_of_reviews(daoObj.getNo_of_reviews());
		return domainObj;
	}

}
