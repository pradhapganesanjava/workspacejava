package com.pg.java.objs;

import java.util.ArrayList;
import java.util.List;

public class ObjRefInParam {

	public static void main(String[] args) {

		List<Integer> intLst = new ArrayList<Integer>();
		ObjRefInParam.overrideObjParam_StaticM(intLst);
		intLst.forEach(System.out::println);
		
		/*List<Integer> intListNullRef=null;
		ObjRefInParam.overrideObjParam_StaticM(intListNullRef);
		intListNullRef.forEach(System.out::println);*/
		
		ObjRefInParam objRef = new ObjRefInParam();
		List<Integer> intListNullRef_ObjM=null;
		objRef.overrideObjParam(intListNullRef_ObjM);
		intListNullRef_ObjM.forEach(System.out::println);
	}

	private static void overrideObjParam_StaticM(List<Integer> intList){
		if(intList==null){
			intList = new ArrayList<Integer>();
		}
		intList.add(1);
		intList.add(2);
		intList.add(3);
	}
	
	private void overrideObjParam(List<Integer> intList){
		if(intList==null){
			intList = new ArrayList<Integer>();
		}
		intList.add(11);
		intList.add(22);
		intList.add(33);
	}
}


