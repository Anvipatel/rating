package com.org.revrep.backend.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.revrep.backend.domain.review.ReviewDAO;
import com.org.revrep.backend.events.entity.NewReviewAdded;
import com.org.revrep.backend.repository.ReviewRepo;
import com.org.revrep.web.view.review.Review;
import com.org.revrep.web.view.review.ReviewFormToReviewInfo;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	
	private ReviewRepo reviewRepo;	
	private ReviewFormToReviewInfo reviewFormToReviewInfo;

	
	@Autowired
	public ReviewServiceImpl(ReviewRepo reviewRepo, ReviewFormToReviewInfo  reviewFormToReviewInfo){
		this.reviewRepo=reviewRepo;
		this.reviewFormToReviewInfo = reviewFormToReviewInfo;
	}
	
	@Override
	@Transactional
	public ReviewDAO addNewReport(Review reviewForm) {
		//Persisting ReviewAddInfo by converting them into Entity Object
	    ReviewDAO reviewInfo = saveOrUpdate(reviewFormToReviewInfo.convert(reviewForm));

        System.out.println("Saved Product Id: " + reviewInfo.getId());
        return reviewInfo;
		// persisted will have Id
		//return new ReviewInfo(reviewForm, UUID.randomUUID().toString());
	}

	@Override
	public void publishForNewReport(ReviewDAO info) {
		//a separate application event publisher which will deal with sync/async operations
		eventPublisher.publishEvent(new NewReviewAdded(info));
	}

	@Override
	public List<ReviewDAO> getReviews(String prodId) {
		return reviewRepo.findByProductId(prodId);		 
	}
	
    @Override
    public ReviewDAO saveOrUpdate(ReviewDAO review) {
        reviewRepo.save(review);
        return review;
    }
	
	@Override
    public ReviewDAO saveOrUpdateProductForm(Review reviewForm) {
		return null;
    
    }

}
