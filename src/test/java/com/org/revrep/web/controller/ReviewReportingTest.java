package com.org.revrep.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.org.revrep.backend.service.ReviewService;
import com.org.revrep.web.exception.BusinessValidationException;
import com.org.revrep.web.exception.RestExceptionHandler;
import com.org.revrep.web.view.review.Review;
import com.org.revrep.web.view.review.ReviewAddInfoTest;

/**
 * @author Anvi P
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ReviewReportingTest {

	private MockMvc		  mockMvc;
 
	@InjectMocks
	ReviewReporting		  reviewReporting;

	@Mock
	private ReviewService reviewService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders
			.standaloneSetup(reviewReporting)
			.setControllerAdvice(new RestExceptionHandler())
			.build();
	}

	@Test(expected = Test.None.class)
	public void addReport_Successfully_201() throws Exception {
		Mockito.when(reviewService.addNewReport(Mockito.any(Review.class))).thenReturn(ReviewAddInfoTest.withCompleteInfoAsObj());

		this.mockMvc
			.perform(post("/review/add").contentType(MediaType.APPLICATION_JSON_UTF8).content(ReviewAddInfoTest.withCompleteInfo()))
			.andDo(print())
			.andExpect(status().is(HttpStatus.CREATED.value()));
	}

	@Test(expected = Test.None.class)
	public void failed_With_Spring_validation_Error_400() throws Exception {
		this.mockMvc
			.perform(post("/review/add").contentType(MediaType.APPLICATION_JSON_UTF8).content(ReviewAddInfoTest.withOutCompleteInfo()))
			.andDo(print())
			.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
	}

	@Test(expected = Test.None.class)
	public void failed_With_User_Error_400() throws Exception {
		Mockito.when(reviewService.addNewReport(Mockito.any(Review.class))).thenThrow(new BusinessValidationException("description is required."));

		this.mockMvc
			.perform(post("/review/add").contentType(MediaType.APPLICATION_JSON_UTF8).content(ReviewAddInfoTest.withCompleteInfo()))
			.andDo(print())
			.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
	}
}
