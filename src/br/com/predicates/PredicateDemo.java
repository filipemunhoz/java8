package br.com.predicates;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Interface funcional com metodo abstrato
 * @author fcmunhoz
 *
 */
public class PredicateDemo {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(-1, -2, -3, -4, -7 ,-10, 1, 2, 3, 4, 6, 8, 9, 0, 12, 44, 87);
		List<Integer> filtered = getFilteredNumbers(numbers, IntegerPredicates.positives);
			
		filtered.forEach(System.out::println);
	}
	
	public static List<Integer> getFilteredNumbers(List<Integer> numbers, Predicate<Integer> predicate){		
		return numbers.stream()
				.filter(predicate)
				.collect(Collectors.<Integer>toList());		
	}
}
