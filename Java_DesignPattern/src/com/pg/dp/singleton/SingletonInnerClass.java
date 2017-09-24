package com.pg.dp.singleton;

public class SingletonInnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Something {
	private Something() {}

	private static class LazyHolder {
		static final Something INSTANCE = new Something();}

	public static Something getInstance() {
		return LazyHolder.INSTANCE; }
}