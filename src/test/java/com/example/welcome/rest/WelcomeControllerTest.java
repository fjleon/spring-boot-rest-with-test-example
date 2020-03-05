package com.example.welcome.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WelcomeControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@LocalServerPort
    int port;
	
	@Before
	public void setup() {
		RestAssured.port = port; 
		RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
	}
	
	@Test 
	public void sortValidTest() {
		given()
			.contentType(ContentType.JSON)
			.body(Arrays.asList(1, 15, 5, 7, 3))
		.when()
			.post("/welcome")
		.then()
			.statusCode(HttpStatus.OK.value())
			.body("", equalTo(Arrays.asList(15, 7, 3, 5, 1)));
	}
	
	@Test
	public void sortEmptyTest() {
		given()
			.contentType(ContentType.JSON)
			.body(new ArrayList<>())
		.when()
			.post("/welcome")
		.then()
			.statusCode(HttpStatus.OK.value())
			.body("", equalTo(new ArrayList<>()));
	}
	
}
