package com.pg.dp.abstfactory;

import org.apache.commons.lang.StringUtils;

public class AbstractCountryFactory {

	public static CountryFactory createCountryFactory(String countryName) {
		if (StringUtils.isNotBlank(countryName)
				&& countryName.toUpperCase().contains("USA")) {
			return FactoryHelper.getInstance(USAStateFactory.class);
		} else if (StringUtils.isNotBlank(countryName)
				&& countryName.toUpperCase().contains("INDIA")) {
			return FactoryHelper.getInstance(IndiaStateFactory.class);
		} else {
			return null;
		}
	}
	
	public static StatesFactory createStateFactory(String countryName){
		if (StringUtils.isNotBlank(countryName)
				&& countryName.toUpperCase().contains("USA")) {
			return FactoryHelper.getInstance(USAStateFactory.class);
		} else if (StringUtils.isNotBlank(countryName)
				&& countryName.toUpperCase().contains("INDIA")) {
			return FactoryHelper.getInstance(IndiaStateFactory.class);
		} else {
			return null;
		}
	}
}
