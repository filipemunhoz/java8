package br.com.funcional;

import java.util.UUID;
import java.util.function.Supplier;

// GUIDE
// https://javatechonline.com/predefined-functional-interfaces/
public class FunctionalSupplier {

	public static void main(String[] args) {
		
		Supplier<String> s = () ->{
			return UUID.randomUUID().toString();
		};		
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
		System.out.println(s.get());
	}
}
