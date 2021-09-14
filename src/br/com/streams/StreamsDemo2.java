package br.com.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo2 {
	
	public static void main(String[] args) throws IOException {
		
		List<String> l = List.of("Notebook", "Puzzle", "Headphone", "Bag");
		l.stream();
	
		// String Builder
		Stream.<String>builder().add("Dog").add("Horse").add("bird");
		
		// Stream with Supplier
		Stream<String> integerStream = Stream.generate(() -> {
			return UUID.randomUUID().toString();
		}).limit(10);
		integerStream.forEach(System.out::println);
		
		
		// Generate odd numbers 
		Stream<Integer> streamOfOddNumbers = Stream.iterate(1, n -> n + 2).limit(50);
		streamOfOddNumbers.forEach(System.out::print);
		
		// File
		Stream<String> filesStream = Files.lines(Paths.get("./README.md"), Charset.forName("UTF-8"));
		filesStream.forEach(System.out::println);
		
		// Primitives
		IntStream i = IntStream.range(1, 10);
		i.forEach(System.out::println);
		
		// Stream of Strings to Collection
		List<String> ls = Stream.of("Red", "Green", "Blue")
				.collect(Collectors.toList());
		
		// Stream of int to Collection
		List<Integer> li = IntStream.of(1, 2, 3, 4, 5)
				.boxed()
				.collect(Collectors.toList());
		
		
		// Igual ao de cima 
		List<Integer> lli = IntStream.of(1, 2, 3, 4, 5, 6)
				.mapToObj(Integer::valueOf)
				.collect(Collectors.toList());
		
		
		int[] intArray = IntStream.of(1, 2, 3, 4, 5, 6).toArray();
		
		// Printing
		System.out.println(Stream.of("a", "b").collect(Collectors.toList()));
		//streamWithIterate.limit(2).forEach(System.out::println);
		
		// Filtering
		Stream<String> la = Stream.of("Catioro", "Vaca", "Sardinha", "Cat");
				la.filter(s -> s.toLowerCase().startsWith("c")).forEach(System.out::println);
	
		// Distinct
		Stream<String> law = Stream.of("Catioro", "Vaca", "Cat", "Sardinha", "Cat", "Vaca");
		law.distinct().forEach(System.out::println);
		
		// Skipping | Limiting
		IntStream sii = IntStream.iterate(1, n -> n + 1);
		sii.skip(9).limit(20).forEach(System.out::println);
	}

}
