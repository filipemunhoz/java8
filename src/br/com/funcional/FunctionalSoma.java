package br.com.funcional;

@FunctionalInterface
interface Math {
	void soma(int a, int b);
}

public class FunctionalSoma {

	public static void main(String[] args) {
		Math m = (a, b) -> System.out.println("Soma igual: " + (a + b));
		m.soma(5, 10);
	}
	 
}
