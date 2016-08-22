package com.pg.generics;

import java.util.ArrayList;
import java.util.List;

public class TemplateGeneric {

	public static void main(String[] str) {


		/*Object attrLookupGroupPojoObj = pojoMap.get(AttrLookupGroupPojo.class.toString());
		if(null != attrLookupGroupPojoObj && attrLookupGroupPojoObj instanceof AttrLookupGroupPojo){
			AttrLookupGroupPojo attrLookupGroupPojo = (AttrLookupGroupPojo) attrLookupGroupPojoObj;
			new AttrLookupGroupDao().saveOrUpdate(attrLookupGroupPojo.getAttrLookupGroupList());
		}*/
		List<MyClass> myClassList = new ArrayList<MyClass>();
		MyClass myClass1 = new MyClass("Camry","Toyota");
		MyClass myClass2 = new MyClass("Carolla","Toyota");
		myClassList.add(myClass1);
		myClassList.add(myClass2);
		

		List<MySecondClass> my2ClassList = new ArrayList<MySecondClass>();
		MySecondClass my2Class1 = new MySecondClass("ThinkPad","Lenovo");
		MySecondClass my2Class2 = new MySecondClass("TouchPad","Lenovo");
		my2ClassList.add(my2Class1);
		my2ClassList.add(my2Class2);

		System.out.println(" myClass "+new TemplateClass(myClassList).getMyTList().toString());
		
		System.out.println(" my2Class "+new TemplateClass(my2ClassList).getMyTList().toString());
	}
}

class TemplateClass<T> {

	List<T> myTList = null;

	public TemplateClass() {
	}

	private Class<T> type;

	public TemplateClass(Class<T> type) {
		this.type = type;
	}

	
	public TemplateClass(List<T> myTList) {
		this.myTList = myTList;
	}
	
	public List<T> getMyTList() {
		return myTList;
	}

	public void setMyTList(List<T> myTList) {
		this.myTList = myTList;
	}


	public Class<T> getType() {
		return type;
	}


	public void setType(Class<T> type) {
		this.type = type;
	}
}

class MyClass{
	String key="MyClass";
	String value ="This is my First Generic Template";
	public MyClass() {}
	
	public MyClass(String key, String value) {
		this.key = key;
		this.value = value; }

	public String toString(){
		return key+" : "+value; }
}

class MySecondClass{
	String key="MySecondClass";
	String value ="This is my SecondClass";
	
	public MySecondClass() {}

	public MySecondClass(String key, String value) {
		this.key = key;
		this.value = value; }

	public String toString(){
		return key+" : "+value; }

}
