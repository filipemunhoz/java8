package br.com.predicates;

import java.util.function.Predicate;

public class IntegerPredicates {
	
	public static Predicate<Integer> positives = new Predicate<Integer>() {
		
		@Override
		public boolean test(Integer i) {
			return i > 0;
		}		
	};

}
