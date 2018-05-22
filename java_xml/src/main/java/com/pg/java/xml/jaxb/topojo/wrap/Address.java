package com.pg.java.xml.jaxb.topojo.wrap;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Address {
 
    private String street;
 
    public String getStreet() {
        return street;
    }
 
    public void setStreet(String street) {
        this.street = street;
    }
 
    public String toString(){
    	return this.street;
    }
}
