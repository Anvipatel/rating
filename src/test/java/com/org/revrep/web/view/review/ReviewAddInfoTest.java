package com.org.revrep.web.view.review;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.org.revrep.backend.domain.review.ReviewDAO;
import com.org.revrep.backend.util.ObjectMapperUtil;

/**
 * @author Anvi P
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ReviewAddInfoTest {

	private static final String	COMPLETE_INFO = "{\"title\":\"Best Product\",\"rating\":5,\"description\":\"This is the best product ever\"}";

	private static final String	WRONG_INFO	  = "{}";

	Validator					validator;

	@Before
	public void init() {
		this.validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test(expected = Test.None.class)
	public void reviewWith_Correct_Data() throws JsonParseException, JsonMappingException, IOException {
		Review info = ObjectMapperUtil.toObject(COMPLETE_INFO, Review.class);
		Set<ConstraintViolation<Review>> errors = this.validator.validate(info);
		assertEquals(0, errors.size());
		assertEquals("Best Product", info.getTitle());
	}

	@Test(expected = Test.None.class)
	public void review_With_In_Correct_data() throws JsonParseException, JsonMappingException, IOException {
		Review info = ObjectMapperUtil.toObject(WRONG_INFO, Review.class);
		Set<ConstraintViolation<Review>> errors = this.validator.validate(info);
		assertEquals(2, errors.size());
	}

	public static String withCompleteInfo() {
		return COMPLETE_INFO;
	}

	public static String withOutCompleteInfo() {
		return WRONG_INFO;
	}

	public static ReviewDAO withCompleteInfoAsObj() throws JsonParseException, JsonMappingException, IOException {
		return ObjectMapperUtil.toObject(withCompleteInfo(), ReviewDAO.class);
	}

}
