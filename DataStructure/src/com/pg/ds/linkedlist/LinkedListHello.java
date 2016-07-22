package com.pg.ds.linkedlist;

import java.util.Arrays;
import java.util.LinkedList;

import com.pg.ds.list.ListHello;

public class LinkedListHello extends ListHello{

	LinkedList<String> linkedList = new LinkedList<String>();
	
	public LinkedListHello(String[] arrStr) {
		super(arrStr);
		linkedList = new LinkedList<String>(Arrays.asList(arrStr));
	}
	
	public static void main(String[] args) {
		String[] arrStr = new String[]{"A","B","C","D","Z"};
		LinkedListHello thisIns = new LinkedListHello(arrStr);
		
		//List's features are inherited to LinkedList
		thisIns.listFeaturesInherited(thisIns);
		
		//Insert/Add to LinkedList performs vice better than other List
		//Appends the element to end of the list.
		thisIns.linkedList.add("ADD");

		//iterate LinkedList
		thisIns.iterateLinkedList(thisIns.linkedList);
		
		//Delete/Remove from LinkedList, better than on ArrayList
		//Remove element from end of the list.
		thisIns.linkedList.pop();
		
		//iterate LinkedList
		thisIns.iterateLinkedList(thisIns.linkedList);
	}
	

	private void iterateLinkedList(LinkedList<String> linkListStr) {
		System.out.println(">Iterate through LinkedList");
		int count=0;
		for(String str:linkListStr){
			System.out.println(count+++":"+str);
		}
		System.out.println();
	}
	
	private void listFeaturesInherited(LinkedListHello thisIns) {
		System.out.println(">List features are available in ArrayList");
		thisIns.getByIndex();
		thisIns.containsSearch();
		thisIns.subListByIndexes();
		thisIns.addOrRemoteFails();
		thisIns.iterateList();
	}
}
