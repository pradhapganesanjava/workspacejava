package com.pg.java.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.pg.java.util.ReflectionUtil;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import sun.reflect.generics.scope.MethodScope;

public class FieldsTest {
	
	public static void main(String...strings){
		
		Field[] concatedArgs = ReflectionUtil.getAllFields(new FieldSampleBO());
		
		for(Field field:concatedArgs){
			System.out.println("Field Name:"+field.getName()+" Type: "+field.getType());
			if(ReflectionUtil.isSimpleInstanceof(field.getType())){
				System.out.println("it is SimpleField ");
			}else if(ReflectionUtil.isCollectionInstance(field.getType())){
				System.out.println("it is Collection instance ");
			}else if(ReflectionUtil.isComplexInstance(field.getType())){
				System.out.println("it is Complex instance ");
				System.out.println(" instance create ? "+ ReflectionUtil.getInstance(field.getType()));
			}else{
				System.out.println("I am not sure ?"+field.getType());
			}
			
			System.out.println("-------------------------------------------------\n");
		}
		
		
		//accessMethods();
	}

	private static Field[] accessAllFields() {
		Field[] declFields = new FieldSampleBO().getClass().getDeclaredFields();
		System.out.println("declared field size: "+declFields.length);
		
		for(Field field:declFields){
			System.out.println("Declared field :"+field.getName());
		}

		Field[] fields = new FieldSampleBO().getClass().getFields();
		System.out.println("field size: "+fields.length);
		
		for(Field field:fields){
			System.out.println("field :"+field.getName());
		}
		
		ArrayList<Field> tempArray = new ArrayList<Field>();
		tempArray.addAll(Arrays.asList(declFields));
		tempArray.addAll(Arrays.asList(fields));
		Field [] concatedArgs = tempArray.toArray(new Field[tempArray.size()]);
		
		System.out.println(" total field size "+concatedArgs.length );
		return concatedArgs;
	}

	private static void accessMethods() {
		Method[] declMethods = new FieldSampleBO().getClass().getDeclaredMethods();
		System.out.println("declared Methods size: "+declMethods.length);
		
		for(Method method:declMethods){
			System.out.println("Declared method name :"+method.getName());
		}
		
		Method[] methods = new FieldSampleBO().getClass().getMethods();
		System.out.println("Methods size: "+methods.length);
		
		for(Method method:methods){
			System.out.println("Methods name: "+method.getName());
		}
	}

}

class FieldSampleBO extends FieldSampleParentBO{
	
	private String childVar = "FieldSampleBO's prop";
	private Integer intVal = 10;
	private Float floatVal = 10.00f;
	private Double doubleVal = 10.00;

	private List listSimple = null; 
	private List<String> listString = null;
	private List<FieldSampleParentBO> listComplex = null;

	private ArrayList arrlistSimple = null; 
	private ArrayList<String> arrlistString = null;
	private ArrayList<FieldSampleParentBO> arrlistComplex = null;
	
	private FieldSampleBO fieldSampleBO;
	private FieldSampleParentBO fieldSampleParentBO;

	public String getChildVar() {
		return childVar;
	}

	public void setChildVar(String childVar) {
		this.childVar = childVar;
	}
}

class FieldSampleParentBO{
	
	public Date mydate = Calendar.getInstance().getTime();
	
	private String parentVar = "FieldSampleParentBO's prop";
	public String pubParentVar = "FieldSampleParentBO's public prop";
	public FieldSampleParentBO fieldSampleParentBO;

	public String getParentVar() {
		return parentVar;
	}

	public void setParentVar(String parentVar) {
		this.parentVar = parentVar;
	}
}