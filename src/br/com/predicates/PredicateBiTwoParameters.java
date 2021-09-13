package br.com.predicates;

import java.util.function.BiPredicate;

public class PredicateBiTwoParameters {
	
	public static void main(String[] args) {
		
		BiPredicate<String, Integer> b = (s1, i1) -> s1.length() == i1;
		System.out.println(b.test("Ok", 2));
		System.out.println(b.test("Nao Ok", 2));
	}

}
