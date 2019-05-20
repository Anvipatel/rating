package com.org.revrep.backend.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.org.revrep.backend.config.ReviewReportingServiceConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ReviewReportingServiceConfiguration.class , loader = AnnotationConfigContextLoader.class)
public class ReviewRepoTest {
	@Autowired
	ReviewRepo reviewRepo ;

	@Test
	public void contextLoads() {
	}
}
