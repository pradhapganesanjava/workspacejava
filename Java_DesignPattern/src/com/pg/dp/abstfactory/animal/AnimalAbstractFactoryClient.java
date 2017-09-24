package com.pg.dp.abstfactory.animal;

public class AnimalAbstractFactoryClient {

	public static void main(String... strings) {

		System.out.println(" animal is breathe "
				+ AnimalAbstractFactory.createAnimalFactory("land")
						.createAnimal().breathe());
		;
	}

}
