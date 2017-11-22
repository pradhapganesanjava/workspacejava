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

public class SingletonSerializable {
	public static void main(String...arg){
		PersonSingle person = PersonSingle.createIns("Pradhap", "000-00-1111", "10/10/1988");
		System.out.println("Serializing obj "+person.toString()+" hashcode: "+person.hashCode());
		String fName = "personsingle.ser";
		serialize(person,fName);
		
		PersonSingle personDeser = deSerialize(fName);
		System.out.println("DeSerialized obj "+ (null!=personDeser?personDeser.toString()+" hashcode:"+personDeser.hashCode():null));		
	}
	private static PersonSingle deSerialize(String fName){
		PersonSingle personDeser = null;
		try {
			FileInputStream fi = new FileInputStream(fName);
			ObjectInputStream oi = new ObjectInputStream(fi);
			Object readO = oi.readObject();
			if(null !=readO){
				personDeser = (PersonSingle)readO;
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

	private static void serialize(PersonSingle person,String fName) {
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

class PersonSingle implements Serializable {
	private String name;
	private String ssn;
	private String dob;

	private static PersonSingle SINGLE_INS;
	private static Object mutex = new Object();

	public static PersonSingle createIns(String name, String ssn, String dob) {
		if (SINGLE_INS == null) {
			synchronized (mutex) {
				try {
					if (SINGLE_INS == null) {
						SINGLE_INS = new PersonSingle(name, ssn, dob);
					} else {
						return SINGLE_INS;
					}
				} catch (Exception e) {
					System.err.println("exception " + e.getMessage());
				}
			}
		}
		return SINGLE_INS;
	}

	private PersonSingle(String name, String ssn, String dob) {
		System.out.println("PersonSingle params Constructor");
		this.name = name;
		this.ssn = ssn;
		this.dob = dob;
	}

	public String toString() {
		return new StringJoiner(",", this.name, this.ssn + "," + dob).toString();
	}

	private void readObject(ObjectInputStream ins){
		this.setDob("readObject_set_DOB");
	}
	private void writeObject(ObjectOutputStream out){
		this.setName("writeObject_set_Name");
	}

	private Object readResolve() throws ObjectStreamException {
		return SINGLE_INS;
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