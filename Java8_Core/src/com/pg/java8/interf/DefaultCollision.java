package com.pg.java8.interf;

public class DefaultCollision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface Sail {
	default void operate() {
		System.out.println("Sail::operate"); } }

interface Boat {
	default void operate() {
		System.out.println("Boat:operate"); } }

/*
 Duplicate default methods named operate with the parameters () and () are
 inherited from the types Boat and Sail
*/
class SeaCommute implements Sail, Boat {
	public void operate(){
		System.out.println("must override or handle collision");
		Sail.super.operate(); //invoke default method of parent interface
	} }
