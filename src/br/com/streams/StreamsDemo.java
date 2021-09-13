package br.com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsDemo {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Iron Maiden", "AC/DC", "Metallica", "Evergrey", "Dream Theater", "Symphony X", "Megadeth");

		// Example 1
		list = list.stream()
				.map(String::toUpperCase)
				.sorted()
				.collect(Collectors.toList());

		list.forEach(System.out::println);

		// Example 2
		System.out.println();
		list.stream()
			.filter(s -> s.startsWith("M"))
			.forEach(System.out::println);
		
		//Example 3
		System.out.println();
		list.stream()
			.findFirst()
			.ifPresent(System.out::println);
		
		//Example 4
		System.out.println();
		IntStream.range(1, 4)
			.forEach(System.out::println);
		
		

	}

}
