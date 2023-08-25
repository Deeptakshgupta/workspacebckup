package com.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest -> we don't want spring context to get Tested
class TestingPracticeApplicationTests {

	private Calculator c = new Calculator();
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testSum()
	{
		assertThat(c.doSum(1, 2, 3)).isEqualTo(6);
	}
	
	@Test
	void testPdt()
	{
		assertThat(c.doProduct(2, 3)).isEqualTo(6);
	}
	
}
