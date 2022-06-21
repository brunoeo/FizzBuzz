package br.fatec.fizzbuzz.integration;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FizzBuzzIntegrationTests {

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	void testFizzBizzComParametro() {

		ResponseEntity<String> response = restTemplate.getForEntity("/fizzbuzz?entries=1,2,3,4", String.class);
		assertEquals(response.getStatusCodeValue(), 200);

	}

}
