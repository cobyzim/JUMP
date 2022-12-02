package com.cognixia.jump.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// annotation indicates that this is a test for HelloController
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

	// MockMvc --> helps with mocking the request / response for API
	@Autowired
	private MockMvc mvc;
	
	@Test
	void testHello() throws Exception {
		
		// Steps: Arrange, Act, Assert
		
		// Arrange --> put together info/data you need
		String name = "World";
		String uri = "/api/hello/" + name;
		
		// Mockito is used to create a dummy get request at URI for Hello Controller
		RequestBuilder request = MockMvcRequestBuilders.get(uri);
		
		// Act --> performing test
		// result --> once request performed, this will be response
		MvcResult result = mvc.perform(request).andReturn();
		
		// Assert --> did test pass?
		assertEquals("Hello " + name, result.getResponse().getContentAsString());
	}
	
}
