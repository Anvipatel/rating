package com.org.rating.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.org.rating.backend.domain.converter.ReviewAggDaoToAggregatedReview;
import com.org.rating.backend.domain.dao.AggregatedReviewDAO;
import com.org.rating.backend.repository.ReviewAggregatorRepo;
import com.org.rating.interfaces.service.IProdRatingService;
import com.org.rating.web.domain.AggregatedReview;
import com.org.rating.web.domain.Review;
import com.org.rating.web.exception.BusinessValidationException;
import com.org.rating.web.exception.EntityNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductRatingServiceImpl implements IProdRatingService {

	@Autowired
	private ReviewAggregatorRepo reviewAggregatorRepo;
	
	private ReviewAggDaoToAggregatedReview reviewAggDaoToAggregatedReview;
	
	@Autowired
	public ProductRatingServiceImpl(ReviewAggDaoToAggregatedReview reviewAggDaoToAggregatedReview) {
		this.reviewAggDaoToAggregatedReview = reviewAggDaoToAggregatedReview;
	}
	
	@Override
	public AggregatedReview getReviewRatings(String prodId) {
		if (prodId == null || StringUtils.isEmpty(prodId)) {
			throw new BusinessValidationException("empty prodId");
		}

		AggregatedReviewDAO reviewAggDao = reviewAggregatorRepo.findOne(prodId);
		
		if(reviewAggDao==null) {
			throw new EntityNotFoundException("No productId found.");
		}		
		
		return reviewAggDaoToAggregatedReview.convert(reviewAggDao);
	}
	
	@Override
	public void editReviewRating(Review review){
		AggregatedReviewDAO reviewAggDao = reviewAggregatorRepo.findOne(review.getProductId());
		
		long cnt = reviewAggDao ==null ? 0:reviewAggDao.getNo_of_reviews();
		cnt++;
		log.info("review read "+ cnt);
		if(reviewAggDao ==null) {
			reviewAggDao = new AggregatedReviewDAO();
			reviewAggDao.setProductId(review.getProductId());
		}
		reviewAggDao.setNo_of_reviews(cnt);
		double rat = reviewAggDao ==null ? 0:reviewAggDao.getRating();
		rat = (rat*(cnt-1)+review.getRating())/cnt;
		reviewAggDao.setRating(rat);
		
		reviewAggregatorRepo.save(reviewAggDao);
		
	}
}
