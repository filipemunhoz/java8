package br.com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exemplo1 {
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("Iron Maiden", "AC/DC", "Metallica", "Evergrey", "Dream Theater", "Symphony X");
		
		list = list.stream()
			.map(String::toUpperCase)
			.sorted()
			.collect(Collectors.toList());
		
		list.forEach(System.out::println);
		
	}

}
