package com.org.revrep.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.org.revrep.web.exception.RestExceptionHandler;
import com.org.revrep.web.view.review.ReviewAddInfoTest;

/**
 * TDD 
 * @author Anvi P
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class SignUpControllerTest {

	private MockMvc		  mockMvc;
	
	@InjectMocks
	SignUpConttoller signUpController;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders
			.standaloneSetup(signUpController)
			.setControllerAdvice(new RestExceptionHandler())
			.build();
	}
	
	
	@Test(expected=Exception.class)
	public void signUp_Return_Error_400() throws Exception {
		
		this.mockMvc
		.perform(post("/signup").contentType(MediaType.APPLICATION_JSON_UTF8).content(ReviewAddInfoTest.withCompleteInfo()))
		.andDo(print())
		.andExpect(status().is(HttpStatus.CREATED.value()));
	}
	
	
	
	
}
