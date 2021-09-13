package br.com.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
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
		
	}

}
