package com.example.individualprep;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IndividualprepApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void applicationClassExists() {
		// This test ensures the application class exists and can be instantiated
		IndividualprepApplication app = new IndividualprepApplication();
		org.junit.jupiter.api.Assertions.assertNotNull(app);
	}
}
