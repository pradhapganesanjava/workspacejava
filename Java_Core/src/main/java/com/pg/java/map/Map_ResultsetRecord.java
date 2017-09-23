package com.pg.java.map;

import java.util.HashMap;
import java.util.Map;

public class Map_ResultsetRecord {

	public static void main(String...str){
		
		MapContainer mpc = new MapContainer();
		mpc.put(String.class, "A");
		mpc.put(Integer.class, 1);
		mpc.put(Double.class, 1.0);
		
		System.out.println(mpc.toString());

		MapObjContainer moc = new MapObjContainer();
		moc.put(String.class, "A");
		moc.put(Integer.class, 1);
		moc.put(Double.class, 1.0);
		moc.put("A","A");
		moc.put(1,1);
		moc.put(1.0,1.1);
		moc.put(MapContainer.class,mpc);
		
		System.out.println(moc.toString());
	
	}
	
	
}
class MapObjContainer{
	
	private Map<Object,Object> mp = new HashMap<>();
	
	public <T> void put(T objKey, T objVal){
		mp.put(objKey, objVal);
	}
	
	public <T> T get(T objKey){
		return (T)mp.get(objKey);
	}
	
	public String toString(){
		return mp.toString();
	}
	
}
class MapContainer{
	
	private Map<Class<?>,Object> mp = new HashMap<>();
	
	public <T> void put(Class<T> classType, T obj){
		mp.put(classType, obj);
	}
	
	public <T> T get(Class<T> classTypeKey){
		return classTypeKey.cast(mp.get(classTypeKey));
	}
	
	public String toString(){
		return mp.toString();
	}
	
}