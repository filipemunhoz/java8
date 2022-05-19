package br.com.generics;

public class Printer <T extends Animal>{
	
	T printer;
	
	public Printer(T printer){
		this.printer = printer;
	}
	
	public void print() {
		printer.eat();
	}

}
