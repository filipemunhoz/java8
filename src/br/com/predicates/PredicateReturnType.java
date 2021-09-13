package br.com.predicates;

import java.util.function.Function;

//GUIDE
//https://javatechonline.com/predefined-functional-interfaces/
public class PredicateReturnType {

	
	
	public static void main(String[] args) {
		
		Function<String, Integer> f = s -> s.length();
		System.out.println(f.apply("Quantos caracteres tem aqui"));
		
	}
}
