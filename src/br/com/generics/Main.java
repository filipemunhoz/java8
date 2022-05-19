package br.com.generics;

public class Main {
	
	public static void main(String[] args) {
		Printer<Dog> p = new Printer<>(new Dog());
		p.print();
		
		Printer<Cat> c = new Printer<>(new Cat());
		c.print();
	}
	
	
}