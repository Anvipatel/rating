package com.org.rating.web.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.org.rating.web.controller.ProductRatingController;
import com.org.rating.web.domain.AggregatedReview;
import com.org.rating.web.exception.EntityNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(ProductRatingManagement.class)
public class ProductRatingManagementTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductRatingController prodRatingController;

	@Test
	public void getProductById_success_200() throws Exception {
		Mockito.when(prodRatingController.getReviewRatings(Mockito.anyString())).thenReturn(new AggregatedReview());
		
		mockMvc.perform(MockMvcRequestBuilders.get("/ratings/xyz").accept(MediaType.APPLICATION_JSON_UTF8))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().is(200));
		
		Mockito.verify(prodRatingController, Mockito.times(1)).getReviewRatings(Mockito.anyString());
	}

	@Test
	public void getProductById__when_not_found_404() throws Exception {

		Mockito.when(prodRatingController.getReviewRatings(Mockito.anyString())).thenThrow(new EntityNotFoundException("No product with given Id found."));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/ratings/xyz").accept(MediaType.APPLICATION_JSON_UTF8))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().is(404));
		
		Mockito.verify(prodRatingController, Mockito.times(1)).getReviewRatings(Mockito.anyString());
	}
}
