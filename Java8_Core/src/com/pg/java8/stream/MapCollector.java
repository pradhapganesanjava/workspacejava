package com.pg.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapCollector {

	public static void main(String[] args) {
		// mapCollectors();

		// filterInternals();

		List<Product> products = new ArrayList<Product>(Arrays.asList(new Product(1, 10), new Product(2, 30), new Product(3, 30)));
		Product p = products.stream().reduce(new Product(4, 0), (p1, p2) -> {
			p1.price += p2.price;
			return new Product(p1.id, p1.price);
		});
		System.out.println(p.toString());
		products.add(p);
		products.stream().parallel().reduce((p1, p2) -> p1.price > p2.price ? p1 : p2).ifPresent(System.out::println);

	}

	private static void filterInternals() {
		List<String> str = Arrays.asList("my", "pen", "is", "your", "pen");
		Predicate<String> test = s -> {
			int i = 0;
			boolean result = s.contains("pen");
			System.out.print((i++) + ":");
			return result;
		};
		str.stream().filter(test).findFirst().ifPresent(System.out::print);
	}

	private static void mapCollectors() {
		List<Emp> li = Arrays.asList(new Emp("Sam", 20), new Emp("John", 60), new Emp("Jim", 51));
		Predicate<Emp> agVal = s -> s.getEAge() > 50;// line n1
		li = li.stream().filter(agVal).collect(Collectors.toList());
		Stream<String> names = li.stream().map(Emp::getEName);// line n2
		names.forEach(n -> System.out.print(n + " "));
	}

}

class Emp {
	private String eName;
	private Integer eAge;

	Emp(String eN, Integer eA) {
		this.eName = eN;
		this.eAge = eA;
	}

	public Integer getEAge() {
		return eAge;
	}

	public String getEName() {
		return eName;
	}
}

class Product {
	int id;
	int price;

	public Product(int id, int price) {
		this.id = id;
		this.price = price;
	}

	public String toString() {
		return id + ":" + price;
	}
}