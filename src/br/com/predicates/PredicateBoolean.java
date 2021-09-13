package br.com.predicates;

import java.util.function.Predicate;

public class PredicateBoolean {
	public static void main(String[] args) {
		
		// Single digit
		Predicate<Integer> p = (value) -> (value > -10 && value < 10);
		System.out.println(p.test(2));
		System.out.println(p.test(4));
		System.out.println(p.test(-11));
		System.out.println(p.test(10));
		System.out.println(p.test(-8));		
	}

}
