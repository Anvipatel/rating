package com.org.rating.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.org.rating.interfaces.controller.IProdRatingController;
import com.org.rating.interfaces.service.IProdRatingService;
import com.org.rating.web.domain.AggregatedReview;

/**
 * @author Anvi
 *
 */
@Controller
public class ProductRatingController implements IProdRatingController {
	
	@Autowired
	private IProdRatingService prodRatingService;

	public AggregatedReview getReviewRatings(String productId) {
		return prodRatingService.getReviewRatings(productId);
	}
}
