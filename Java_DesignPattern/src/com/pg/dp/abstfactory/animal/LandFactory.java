package com.pg.dp.abstfactory.animal;

public class LandFactory implements AnimalFactory {
	@Override
	public Animal createAnimal() {
		return new Elephant();
	}

}
