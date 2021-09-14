package br.com.maps;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapFlatMap {
	
	
	public static void main(String[] args) {
		
		// Map: It produces single value for each input value.
		List<Person> ll = List.of(new Person("Zoclo", List.of("PHP", "Python", "Java")),
						new Person("Robert", List.of("ASP", "Visual Basic", "Delphi")),
						new Person("Dunha", List.of("Clipper", "Golang", "Assembly")));
		
		
		ll.stream()
			.map(Person::getName)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("-------------------------------------------------");
		
		// FlatMap: It produces multiple values for each input value.
		ll.stream()
			.flatMap(p -> p.getSkills().stream())
			.collect(Collectors.toSet())
			.forEach(System.out::println);
		
		
	}

	// Peek: observe the method below how it prints the values between the various intermediate operations.
	public int triplesDivisibleBy2Sum(int start, int end) {
	    return IntStream.rangeClosed(start, end)
	     .peek(n -> System.out.println("original element : " +n))         //prints value before multiplying by 3
	     .map(n -> n * 3)
	     .peek(n -> System.out.println("Tripled element : " +n))          //prints value before filtering
	     .filter(n -> n % 2 == 0)
	     .peek(n -> System.out.println("Divisible By 2 element : " +n))   //prints value after filtering but before summing
	     .sum();
	}
}



class Person {	
	
	public Person(String name, List<String> skills) {
		super();
		this.name = name;
		this.skills = skills;
	}
	private String name;
	private List<String> skills;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
}