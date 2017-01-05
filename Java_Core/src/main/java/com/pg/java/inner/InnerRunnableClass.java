package com.pg.java.inner;

public class InnerRunnableClass {

	public static void main(String[] args) {

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println(this.toString());
			}
			
			public String toString() {
				System.out.println("inner level");
				return "inner level..";
			}

		};
		
		runnable.run();
		
		Runnable runLambda = () -> System.out.println("lambda");
		runLambda.run();
	}

	@Override
	public String toString() {
		System.out.println("Class level");
		return "Class level..";
	}
}
