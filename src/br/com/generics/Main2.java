package br.com.generics;

public class Main2 {
	
	public static void main(String[] args) {
		
		shout("Alow");
		shout(123);
		shout(new Dog());
	}
	
	public static <T> void shout(T obj) {
		System.out.println("Uhullll " + obj);
	}

}
