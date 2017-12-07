package com.pg.java.thread.whythread;

import java.util.ArrayList;
import java.util.List;

public class ThreadCommReq_Coordinate {

	List<String> sharedData = new ArrayList<String>();
	int OVER_LOAD_THRESHOLD = 20;
	int LOWER_LOAD_THRESHOLD = 5;

	public static void main(String[] args) {
		ThreadCommReq_Coordinate thisIns = new ThreadCommReq_Coordinate();
		for (int i = 0; i < 20; i++) {
			thisIns.sharedData.add(new String(i + ":" + (char) (i + 65)));
		}
		System.out.println(thisIns.sharedData);
	}

	void producer() {
		Runnable run = () -> {
			if (sharedData.size() < OVER_LOAD_THRESHOLD) {
				for (int i = 0; i < 20; i++) {
					sharedData.add(new String(i + " : " + (char) (i + 67)));
				}
			} else {
				System.out.println(" OVER_LOAD_THRESHOLD reached. ");
			}
		};
		Thread th = new Thread(run);
	}

}

interface MyProcessor {
	void process();
}