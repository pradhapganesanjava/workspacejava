package com.pg.ds.arrlist;

import java.util.ArrayList;
import java.util.Arrays;

import com.pg.ds.list.ListHello;

public class ArrayListHello extends ListHello {

	ArrayList<String> listOfArrStr = new ArrayList<String>();

	public ArrayListHello(String[] arrStr) {
		super(arrStr);
		this.listOfArrStr = new ArrayList<String>(Arrays.asList(arrStr));
	}

	public static void main(String[] args) {

		String[] arrStr = new String[] { "A", "B", "C", "D", "E" };
		ArrayListHello thisIns = new ArrayListHello(arrStr);

		//>List features are available in ArrayList
		listFeaturesInherited(thisIns);

		//>can add to ArrayList
		addToArrayList(thisIns);

		//>can remove from ArrayList
		removeFromArrayList(thisIns);
	}

	private static void removeFromArrayList(ArrayListHello thisIns) {
		System.out.println("can remove from ArrayList");
		System.out.println("before remove, 0th element:" + thisIns.listOfArrStr.get(0));
		thisIns.listOfArrStr.remove(0);
		System.out.println("after remove, 0th element:" + thisIns.listOfArrStr.get(0));
		System.out.println();
	}

	private static void addToArrayList(ArrayListHello thisIns) {
		thisIns.listOfArrStr.add("Z");
		System.out.println("can add to ArrayList");
		System.out.println(thisIns.listOfArrStr.get(thisIns.listOfArrStr.size() > 0 ? thisIns.listOfArrStr
				.size() - 1 : 0));
		System.out.println();
	}

	private static void listFeaturesInherited(ArrayListHello thisIns) {
		System.out.println(">List features are available in ArrayList");
		thisIns.getByIndex();
		thisIns.containsSearch();
		thisIns.subListByIndexes();
		thisIns.addOrRemoteFails();
		thisIns.iterateList();
	}

}
