package br.fatec.fizzbuzz.controller;

import br.fatec.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/fizzbuzz")
public class FizzBuzzController {

    @Autowired
    private FizzBuzzService service;


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> processa(@RequestParam(name = "entries") String numeros){

        try{
            return service.calcList(numeros.split(","));
        }catch (NullPointerException e){
            return service.calcList(null);
        }
    }

}
