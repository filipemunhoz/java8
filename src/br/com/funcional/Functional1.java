package br.com.funcional;

@FunctionalInterface
interface Person {
	void display();
}

public class Functional1 {
	
	public static void main(String[] args) {
		
		Person p = () -> System.out.println("Executing display");
		p.display();
	}

}

// Implementacoes sao equivalentes, com o lambda acima eh resumido codigo
//interface A {
//	  public void m1();
//	}
//
//	public class Demo implements A{
//	  public void m1(){
//	  System.out.println("m1() is executing");
//	  }
//	} 
//
//	public class Test {
//	  public static void main(String[] args){
//	     A a= new Demo();
//		 a.m1();
//	  }
//	}