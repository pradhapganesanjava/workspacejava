package com.pg.alg.listoflist;

import java.util.HashMap;
import java.util.Map;

public class MapOfLinkedLst_LRUCache {

	public static void main(String[] args) {

	}

}

class LRUCache {

	Node head = new Node();
	Node tail = new Node();

	Map<Integer, Node> checkMp = new HashMap<>();
	int CAPS = 0;

	public LRUCache(int capacity) {
		this.CAPS = capacity;

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {

		if (checkMp.containsKey(key)) {
			moveFirst(checkMp.get(key));

			checkMp.entrySet().forEach(entry -> {
				System.out.println("GET " + entry.getKey() + ":" + entry.getValue());
			});

			return checkMp.get(key).val;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {

		if (checkMp.containsKey(key)) {
			moveFirst(checkMp.get(key));
			// checkMp.put(key, mvNd);
		} else {
			if (checkMp.size() < CAPS) {
				Node nNd = addFirst(key);
				checkMp.put(key, nNd);
			} else {
				Node rmNode = removeTail();
				checkMp.remove(rmNode.val);
				Node nNd = addFirst(key);
				checkMp.put(key, nNd);
			}
		}

		checkMp.entrySet().forEach(entry -> {
			System.out.println("A4 PUT " + entry.getKey() + ":" + entry.getValue());
		});
	}

	private void moveFirst(Node mvNd) {
		removeNode(mvNd);
		addFirst(mvNd);
	}

	private Node addFirst(Node nwNd) {
		Node nextNd = head.next;

		head.next = nwNd;

		nwNd.prev = head;
		nwNd.next = nextNd;

		head.next.prev = nwNd;

		return nwNd;
	}

	private Node addFirst(int nwVal) {
		Node nwNd = new Node();
		nwNd.val = nwVal;

		nwNd.prev = head;
		nwNd.next = head.next;

		head.next.prev = nwNd;
		head.next = nwNd;

		return nwNd;
	}

	private Node removeNode(Node rmNd) {
		Node prevNd = rmNd.prev;
		Node nextNd = rmNd.next;

		prevNd.next = nextNd;
		nextNd.prev = prevNd;
		return rmNd;
	}

	private Node removeTail() {
		return removeNode(tail.prev);
	}
}

class Node {
	int val;
	Node next;
	Node prev;

	@Override
	public String toString() {
		return prev.val + " <-- " + val + " -->" + next.val;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */