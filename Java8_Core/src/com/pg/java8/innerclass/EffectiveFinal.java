package com.pg.java8.innerclass;

public class EffectiveFinal {

	public static void main(String[] args) {
		EffectiveFinal eff = new EffectiveFinal();
		eff.localMethod();
	}

	public void localMethod() {
		int x = 10; // <java8 the variable supposed to be defined as final after
					// java8 not mandate.

		class LocalInnerClass {

			void localInCMethod() {
				System.out.println(x);
			}

		}
		// x = 11; not allowed comp_err: Local variable x defined in an
		// enclosing scope must be final or effectively final

		LocalInnerClass linC = new LocalInnerClass();
		linC.localInCMethod();

	}

}
