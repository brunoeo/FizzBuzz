package br.fatec.fizzbuzz.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@SpringBootTest
class FizzBuzzServiceTests {

	@Autowired
	private FizzBuzzService service;

	@Test
	void verificaTransformacao() {
		String valores = "1,3,5,30";

		String[] numeros = valores.split(",");

		ResponseEntity response = service.calcList(numeros);

		assertEquals("[1, fizz, buzz, fizzbuzz]", response.getBody().toString());
	}

	@Test
	void verificaTransformacaoComValoresErrados() {
		String valores = "1,3,5,30,5.2,15,x";

		String[] numeros = valores.split(",");

		ResponseEntity response = service.calcList(numeros);

		assertEquals("[1, fizz, buzz, fizzbuzz, fizzbuzz]", response.getBody().toString());
	}


	@Test
	void enviaVazio() {
		String valores = "";

		String[] numeros = valores.split(",");

		ResponseEntity response = service.calcList(numeros);

		ArrayList<String> lista = (ArrayList<String>) response.getBody();

		assertEquals(100, lista.size());

	}

	@Test
	void enviaNullo() {

		ResponseEntity response = service.calcList(null);

		ArrayList<String> lista = (ArrayList<String>) response.getBody();

		assertEquals(100, lista.size());

	}

}
