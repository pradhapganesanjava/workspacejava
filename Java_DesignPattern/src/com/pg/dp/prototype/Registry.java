package com.pg.dp.prototype;

import java.util.Hashtable;

public class Registry {
	public static void main(String[] args) {
		ItemRegistry registry = new ItemRegistry();
		Book myBook = (Book) registry.createBasicItem("Book");
		myBook.setTitle("Custom Title");
	} }

class ItemRegistry {
	private Hashtable<String,Item> map = new Hashtable<>();

	public ItemRegistry() {
		loadCache(); }

	public Item createBasicItem(String type) {
		return map.get(type).clone(); }

	private void loadCache() {
		Book book = new Book();
		createBasicBook(book);
		CD cd = new CD();
		createBasicCD(cd); }

	private void createBasicBook(Book book) {
		book.setTitle("Design Patterns");
		book.setPrice(20.00);
		map.put("Book", book);
	}

	private void createBasicCD(CD cd) {
		cd.setTitle("Various");
		cd.setPrice(10.00);
		map.put("CD", cd);
	}
}

//// Prototype
abstract class Item {
	private String title;
	private double price;

	public Item clone() {
		Item clonedItem = null;
		try {
			// use default object clone.
			clonedItem = (Item) super.clone();
			// specialised clone
			clonedItem.setPrice(price);
			clonedItem.setTitle(title);
		} catch (CloneNotSupportedException e) { e.printStackTrace(); }
		return clonedItem;
	}

	public String getTitle() { return title; }

	public double getPrice() { return price; }

	public void setTitle(String title) {  this.title = title;  }

	public void setPrice(double price) {  this.price = price;  }
}

// Concrete Prototypes
class Book extends Item {
	// extra book stuff
}

class CD extends Item {
	// extra cd stuff
}