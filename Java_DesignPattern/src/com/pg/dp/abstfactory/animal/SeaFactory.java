package com.pg.dp.abstfactory.animal;

public class SeaFactory implements AnimalFactory{
	@Override
	public Animal createAnimal() {
		return new Shark();
	}

}
