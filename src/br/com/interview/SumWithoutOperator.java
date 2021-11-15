package br.com.interview;

public class SumWithoutOperator {

	public static void main(String[] args) {
		SumWithoutOperator a = new SumWithoutOperator();		
		System.out.println(a.soma(6, 5));
		//System.out.println(a.soma(35, 12));
	}

	public int soma(int x, int y) {
		while (y != 0) {
			int carry = x & y;
			System.out.println(Integer.toString(carry, 2));
			x = x ^ y;
			y = carry << 1;
			System.out.println(y);
		}
		return x;
	}
}