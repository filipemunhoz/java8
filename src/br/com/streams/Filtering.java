package br.com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Filtering {
	
	public static void main(String[] args) {
		
		// Find first divisivel por 2
		Optional<Integer> o = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
			.filter(i -> i % 2 == 0)
			.findFirst();
		
		System.out.println(o);
		
		
		// Matches
		List<String> listOfSkills = Arrays.asList("Core Java", "Spring Boot", "Hibernate", "Angular"); 

		Predicate<String> pred = x -> x.startsWith("S"); 
		System.out.println(listOfSkills.stream().anyMatch(pred));         // true 
		System.out.println(listOfSkills.stream().allMatch(pred));         // false 
		System.out.println(listOfSkills.stream().noneMatch(pred));   
		
	}

}
