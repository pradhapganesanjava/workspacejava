package com.pg.java8.autoclose;

import java.io.IOException;

public class CloseableTest {

	public static void main(String[] args) throws Exception {
		try (Folder f = new Folder()) {
			f.open();
		}
	}

}

final class Folder implements AutoCloseable { // line n1
	public void close() throws IOException {
		System.out.print("Close");
	}

	public void open() {
		System.out.print("Open");
	}
}
