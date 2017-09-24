package com.pg.dp.abstfactory.animal;

import org.apache.commons.lang.StringUtils;

public class AnimalAbstractFactory {
	public static AnimalFactory createAnimalFactory(String type) {
		if (StringUtils.isNotBlank(type) && "WATER".equalsIgnoreCase(type)) {
			return new SeaFactory();
		} else {
			return new LandFactory();
		}
	}

}
