package com.org.rating.backend.jms.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.org.rating.backend.events.entity.NewReviewAdded;
import com.org.rating.backend.repository.ReviewAggregatorRepo;
import com.org.rating.interfaces.service.IProdRatingService;

@Service
public class KReviewAggregatorConsumer {
	private ReviewAggregatorRepo reviewAggRepo;
	
	@Autowired
	public KReviewAggregatorConsumer(ReviewAggregatorRepo reviewAggRepo) {
		this.reviewAggRepo = reviewAggRepo;
	}
	
	@Autowired
	IProdRatingService prodRatingService;
	
	@KafkaListener(topics = NewReviewAdded.EVENT_NAME, containerFactory = "kafkaListenerContainerFactory")
	public void consumeReviewAddEvent(NewReviewAdded review) {
		System.out.println("Consuming review add event "+ review);
		prodRatingService.editReviewRating(review.getReviewInfo());
	}
	

}
