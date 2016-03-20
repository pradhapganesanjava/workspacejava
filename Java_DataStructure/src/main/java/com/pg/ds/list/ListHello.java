package com.pg.ds.list;

import java.util.Arrays;
import java.util.List;

public class ListHello {
	
	static List<String> listOfArrStr = null;
	
	public ListHello() {
		ListHello.listOfArrStr = Arrays.asList(new String[]{"A","B","C","D","E"});	
	}

	public ListHello(String[] arrStr) {
		ListHello.listOfArrStr = Arrays.asList(arrStr);;	
	}

	public static void main(String[] args) {

		ListHello listHello = new ListHello();
		
		//>Randomly get index based data from List 
		listHello.getByIndex();

		//>Search a List for specific value 
		listHello.containsSearch();

		//>Get range of data from list
		listHello.subListByIndexes();

		//>Iterate through List
		listHello.iterateList();
		
		//>can NOT add or delete from list
		listHello.addOrRemoteFails();
	}

	public void addOrRemoteFails() {
		System.out.println(">can NOT add or delete using List interface");
		try {
			listOfArrStr.add("Z");
		} catch (Exception e) {
			System.out.println("List.add throws Exception...");
			e.printStackTrace();
		}
		try {
			listOfArrStr.remove(0);
		} catch (Exception e) {
			System.out.println("List.remove throws Exception...");
			e.printStackTrace();
		}
		System.out.println();
	}

	public void iterateList() {
		System.out.println(">Iterate through List");
		int count=0;
		for(String str:listOfArrStr){
			System.out.println(count+++":"+str);
		}
		System.out.println();
	}

	public void subListByIndexes() {
		System.out.println(">Get range of data from list");
		for(String str:listOfArrStr.subList(1, 3)){
			System.out.println(listOfArrStr.indexOf(str)+":"+str);
		}
		System.out.println();
	}

	public void containsSearch() {
		System.out.println(">Search a List for specific value");
		System.out.println("Does List contain element A?: "+listOfArrStr.contains("A"));
		System.out.println();
	}

	public void getByIndex() {
		System.out.println(">Randomly get index based data from List");
		System.out.println("get 0th element: "+listOfArrStr.get(0));
		System.out.println();
	}

}
