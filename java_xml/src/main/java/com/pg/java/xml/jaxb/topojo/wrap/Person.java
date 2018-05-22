package com.pg.java.xml.jaxb.topojo.wrap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PERSON")
public class Person {
 
    private String name;
 
    @XmlElement(name="NAME")
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
     
    public String toString(){
    	return this.name;
    }
}
