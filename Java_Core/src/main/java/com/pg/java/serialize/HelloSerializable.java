package com.pg.java.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.StringJoiner;

public class HelloSerializable {

	public static void main(String[] args) {

		PersonSer person = new PersonSer("Pradhap", "000-00-1111", "10/10/1988");
		System.out.println("Serializing obj "+person.toString()+" hashcode: "+person.hashCode());
		String fName = "person.ser";
		serialize(person,fName);
		
		PersonSer personDeser = deSerialize(fName);
		System.out.println("DeSerialized obj "+ (null!=personDeser?personDeser.toString()+" hashcode:"+personDeser.hashCode():null));
	}

	private static PersonSer deSerialize(String fName){
		PersonSer personDeser = null;
		try {
			FileInputStream fi = new FileInputStream(fName);
			ObjectInputStream oi = new ObjectInputStream(fi);
			Object readO = oi.readObject();
			if(null !=readO){
				personDeser = (PersonSer)readO;
				return personDeser;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void serialize(PersonSer person,String fName) {
		try {
			FileOutputStream fo = new FileOutputStream(fName);
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(person);
			oo.flush();
			oo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
		}
	}

}

class PersonSer implements Serializable{
	private String name;
	private String ssn;
	private String dob;
	
	public PersonSer(){
		System.out.println("PersonSer NoArg Constructor");
	}
	public PersonSer(String name, String ssn, String dob){
		System.out.println("PersonSer params Constructor");
		this.name = name;
		this.ssn = ssn;
		this.dob = dob;
	}
	
	public String toString(){
		return  this.name +" , "+ this.ssn+" , "+this.dob;
	}
	
	private void readObject(ObjectInputStream ins) throws IOException{
		/*//this.setName(this.getName());
		this.setSsn("readObject_set_SSN");
		this.setDob("readObject_set_DOB");*/
		this.name=ins.readUTF();
		this.dob=ins.readUTF();
		this.ssn=ins.readUTF();
	}
	private void writeObject(ObjectOutputStream out) throws IOException{
		out.writeChars("writeObject_set_Name");
	}
	
	/*private Object readResolve() throws ObjectStreamException{
		return this;
	}*/
	
	public String getName() {
		return name;
	}
	public String getSsn() {
		return ssn;
	}
	public String getDob() {
		return dob;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
}