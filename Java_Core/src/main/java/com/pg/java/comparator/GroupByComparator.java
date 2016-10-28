package com.pg.java.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GroupByComparator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("B4 sort ==>");
		List<GroupAcc> groupAccList = populateGroupAcc();
		int count = 0;
		for (GroupAcc groupAcc : groupAccList) {
			System.out.println(count + " : " + groupAcc.toString());
			count++;
		}
		
		Collections.sort(groupAccList, new MyComparator());
		System.out.println("\n\nA4 sort ==>");
		count = 0;
		for (GroupAcc groupAcc : groupAccList) {
			System.out.println(count + " : " + groupAcc.toString());
			count++;
		}	
	}

	private static class MyComparator implements Comparator<GroupAcc> {
		@Override
		public int compare(GroupAcc o1, GroupAcc o2) {
			int srcCompareInt = o1.getSrcType_L1().compareTo(o2.getSrcType_L1());
			if (srcCompareInt == 0) {
				int enrollCompareInt = o1.getAutoEnroll_L2().compareTo(o2.getAutoEnroll_L2());
				if (enrollCompareInt == 0) {
					return o1.getAccType_L2().compareTo(o2.getAccType_L2());
				} else if (enrollCompareInt > 0) {
					return -1;
				} else if (enrollCompareInt < 0) {
					return 1;
				}
			} else if (srcCompareInt > 0) { // creditcard > ach
				return -1;// creditcard goes first
			} else if (srcCompareInt < 0) { // ach < creditcard
				return 1;// ach follows creditcard
			}
			return 0;
		}
	}

	private static List<GroupAcc> populateGroupAcc() {

		List<GroupAcc> groupAccList = new ArrayList<GroupAcc>(6);
		groupAccList.add(new GroupAcc("ach", "checking", "yes"));
		groupAccList.add(new GroupAcc("ach", "checking", "no"));
		groupAccList.add(new GroupAcc("creditcard", "visa", "no"));
		groupAccList.add(new GroupAcc("creditcard", "master", "yes"));
		groupAccList.add(new GroupAcc("ach", "saving", "yes"));
		groupAccList.add(new GroupAcc("ach", "saving", "no"));
		return groupAccList;
	}

}

class GroupAcc {

	public GroupAcc() {
	}

	public GroupAcc(String srcType, String accType, String autoEnroll) {
		this.srcType_L1 = srcType;
		this.accType_L2 = accType;
		this.autoEnroll_L2 = autoEnroll;
	}

	private String accType_L2;
	private String srcType_L1;
	private String autoEnroll_L2;

	public String getAccType_L2() {
		return accType_L2;
	}

	public String getSrcType_L1() {
		return srcType_L1;
	}

	public String getAutoEnroll_L2() {
		return autoEnroll_L2;
	}

	public void setAccType_L2(String accType_L2) {
		this.accType_L2 = accType_L2;
	}

	public void setSrcType_L1(String srcType_L1) {
		this.srcType_L1 = srcType_L1;
	}

	public void setAutoEnroll_L2(String autoEnroll_L2) {
		this.autoEnroll_L2 = autoEnroll_L2;
	}

	public String toString() {
		return srcType_L1 + " : " + accType_L2 + " : " + autoEnroll_L2;
	}
}