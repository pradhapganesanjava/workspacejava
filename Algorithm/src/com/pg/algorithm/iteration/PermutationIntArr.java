package com.pg.algorithm.iteration;

import java.util.ArrayList;
import java.util.List;

public class PermutationIntArr {

	static int[] arr = { 3, 2, 1, 0, 4, 5 };

	public static void main(String[] args) {

		List<String> strLst = new ArrayList<String>();
		int timec = 0;
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			timec++;
			String si = String.valueOf(arr[i]);
			strLst.add(si);

			//for (int j = i + 1; j < len; j++) {
			int j = i + 1;
			String sj = si;
			while ( j < len ){
				timec++;
				sj = sj + String.valueOf(arr[j]);
				strLst.add(sj);

				int t = j + 1;

				while (t < len) {
					timec++;
					String st = sj + String.valueOf(arr[t]);
					strLst.add(st);
					t++;
				}
				j++;
			}
		}

		System.out.println("resultCount: " + strLst.size() + " timecons " + timec);
		strLst.forEach(e -> System.out.println(e));
	}

}
