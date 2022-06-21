package br.fatec.fizzbuzz.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzService {

    public ResponseEntity<?> calcList(String[] numeros){

        List<String> resultado = new ArrayList<>();
        Boolean contain = false;

        if(numeros != null){
            for (String numero : numeros){
                if (!numero.equals("") && !numero.equals(null)){
                    contain = true;
                    break;
                }
            }
        }


        if (contain){
            for (String numero : numeros){
                try{
                    int aux = Integer.parseInt(numero);
                    if (aux % 3 == 0 && aux % 5 == 0){
                        resultado.add("fizzbuzz");
                    }else if(aux % 3 == 0){
                        resultado.add("fizz");
                    } else if (aux % 5 == 0){
                        resultado.add("buzz");
                    }else {
                        resultado.add(numero);
                    }
                }catch (NumberFormatException e){
                    System.out.println(e);
                }
            }
        }else {
            numeros = new String[100];
            for(int i = 0; i<100; i++){
                numeros[i] = Integer.toString(i + 1);
            }
            return calcList(numeros);
        }


        return ResponseEntity.ok(resultado);
    }

}
