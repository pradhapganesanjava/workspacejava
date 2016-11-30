package com.pg.java8.interf;

public class InterfaceJava8 {

	public static void main(String...strings){
		System.out.println( ""+new Cat().toString());
		System.out.println( ""+new Dinosaur().toString());
	}
}


interface Animal{
	
	public static final String EAT_OTHER_ANIMAL = "Carnivore";
	public static final String EAT_PLANT_ANIMAL = "Omnivore";
	public static final String EAT_OWN_ANIMAL = "Cannibal";
	public static final String EAT_PLANT_ONLY = "Herbivore";
	
	public static final String LIVES_IN_FOREST = "Forest";
	public static final String LIVES_IN_WATER = "Water";
	public static final String LIVES_IN_HOUSE = "House";
	/*
	 * Herbivore : An animal that only eats plants
	 * Carnivore : An animal that eats other animal
	 * Omnivore  : An animal eats plants and Flesh 
	 * Cannibal  : An animal eats own family animal
	 */
	public String eatHabit();
	public boolean isWild();
	default String livesIn() {
		return LIVES_IN_FOREST;
	}
	
	static String comment(){
		return "Animals are wild in nature, some animals after trained become friendly\n";
	}
}

class Cat implements Animal{
	@Override
	public String eatHabit() {
		return EAT_PLANT_ANIMAL;
	}
	
	@Override
	public boolean isWild() {
		return true;
	}
	
	@Override
	public String livesIn() {
		return LIVES_IN_HOUSE;
	}

	public String toString(){
		return Animal.comment()+"EatHabit: "+this.eatHabit()+" isWild: "+this.isWild()+" LiveIn: "+this.livesIn();
	}
}

class Dinosaur implements Animal{
	@Override
	public String eatHabit() {
		return EAT_OTHER_ANIMAL;
	}
	
	@Override
	public boolean isWild() {
		return true;
	}
	
	public String toString(){
		return Animal.comment()+"EatHabit: "+this.eatHabit()+" isWild: "+this.isWild()+" LiveIn: "+this.livesIn();
	}
}