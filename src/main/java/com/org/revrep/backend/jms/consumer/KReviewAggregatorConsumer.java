package com.org.revrep.backend.jms.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.org.revrep.backend.domain.review.ReviewAggregatorDAO;
import com.org.revrep.backend.domain.review.ReviewDAO;
import com.org.revrep.backend.events.entity.NewReviewAdded;
import com.org.revrep.backend.repository.ReviewAggregatorRepo;

@Service
public class KReviewAggregatorConsumer {
	private ReviewAggregatorRepo reviewAggRepo;
	
	@Autowired
	public KReviewAggregatorConsumer(ReviewAggregatorRepo reviewAggRepo) {
		this.reviewAggRepo = reviewAggRepo;
	}
	
	
	@KafkaListener(topics = NewReviewAdded.EVENT_NAME, containerFactory = "kafkaListenerContainerFactory")
	public void consumeReviewAddEvent(ReviewDAO reviewDao) {
		System.out.println("Consuming review add event "+ reviewDao);
		ReviewAggregatorDAO reviewAggDao = reviewAggRepo.findOne(reviewDao.getProductId());
		long cnt = reviewAggDao ==null ? 0:reviewAggDao.getCount();
		cnt++;
		System.out.println("review read "+ cnt);
		if(reviewAggDao ==null) {
			reviewAggDao = new ReviewAggregatorDAO();
			reviewAggDao.setProductId(reviewDao.getProductId());
		}
		reviewAggDao.setCount(cnt);
		double rat = reviewAggDao ==null ? 0:reviewAggDao.getRating();
		rat = (rat+reviewDao.getRating())/cnt;
		reviewAggDao.setRating(rat);
		
		reviewAggRepo.save(reviewAggDao);
		
	}

}
