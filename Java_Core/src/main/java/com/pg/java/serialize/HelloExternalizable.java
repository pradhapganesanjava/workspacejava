package com.pg.java.serialize;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.StringJoiner;

public class HelloExternalizable {

	public static void main(String[] args) {

		PersonExt person = new PersonExt("Pradhap", "000-00-1111", "10/10/1988");
		System.out.println("Serializing obj "+person.toString()+" hashcode: "+person.hashCode());
		String fName = "person.ser";
		serialize(person,fName);
		
		PersonExt personDeser = deSerialize(fName);
		System.out.println("DeSerialized obj "+ (null!=personDeser?personDeser.toString()+" hashcode:"+personDeser.hashCode():null));
	}

	private static PersonExt deSerialize(String fName){
		PersonExt personDeser = null;
		try {
			FileInputStream fi = new FileInputStream(fName);
			ObjectInputStream oi = new ObjectInputStream(fi);
			Object readO = oi.readObject();
			if(null !=readO){
				personDeser = (PersonExt)readO;
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

	private static void serialize(PersonExt person,String fName) {
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

class PersonExt implements Externalizable{
	private transient String name;
	private String ssn;
	private String dob;
	
	public PersonExt(){
		System.out.println("PersonExt NoArg Constructor");
	}
	public PersonExt(String name, String ssn, String dob){
		System.out.println("PersonExt params Constructor");
		this.name = name;
		this.ssn = ssn;
		this.dob = dob;
	}
	
	public String toString(){
		return this.name+" , "+this.ssn+","+dob;
	}
	
	private void readObject(ObjectInputStream ins){
		this.setDob("readObject_set_DOB");
	}
	private void writeObject(ObjectOutputStream out){
		this.setName("writeObject_set_Name");		
	}
	private Object readResolve() throws ObjectStreamException{
		return this;
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF("writeExternal_set_Name");
		out.writeUTF("writeExternal_set_dob");
		out.writeUTF("writeExternal_set_ssn");
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		name = in.readLine();
	}
	
	
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