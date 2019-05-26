package com.org.rating;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.org.rating.backend.config.ProductRatingServiceConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductRatingServiceConfiguration.class)
public class ProductRatingServiceApplicationTest {

	@Test
	public void contextLoads() {
	}

}
