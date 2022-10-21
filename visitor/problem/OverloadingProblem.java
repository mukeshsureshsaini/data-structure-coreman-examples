package com.alpha.visitor.problem;

/* *
 * 
 * 
 * 
 * to understand visitor pattern visit a shopping mall for purchase 
 * 
 * 
 * 
 * */

class Alpha {

	public void dothis() {

		System.out.println("Alpha");
	}
}

class Beta extends Alpha {
	@Override
	public void dothis() {
		System.out.println("Beta");
	}
}

class Gamma extends Alpha {
	@Override
	public void dothis() {
		System.out.println("Gamma");
	}
}

class Doer {

	public void print(Alpha a) {
		// a.dothis();
		System.out.println("With Alpha");
	}

	public void print(Beta b) {
		// b.dothis();

		System.out.println("With Beta");

	}

	public void print(Gamma g) {

		// g.dothis();

		System.out.println("With Gamma");
	}
}

public class OverloadingProblem {

	public static void main(String[] args) {

		Doer d1 = new Doer();
//		d1.print(new Alpha());
//		d1.print(new Beta());
//		d1.print(new Gamma());

		// so far so good

		Alpha a1 = new Alpha();

		Alpha a2 = new Beta();

		Alpha a3 = new Gamma();

		d1.print(a1);
		d1.print(a2);
		d1.print(a3);

	}

}
