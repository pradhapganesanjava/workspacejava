package com.pg.dp.abstfactory;

public class CountryAbstractFactoryClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//IndiaStateFactory indFactory = (IndiaStateFactory) CountryAbstractFactory.createCountryFactory(India.class.getName());
		CountryFactory indFactory = CountryAbstractFactory.createCountryFactory(USA.class.getName());
		System.out.println(indFactory.createCountry().getAllStates());
		//System.out.println(((States)indFactory.createStatesFactory(TamilNadu.class)).stateTax());
		
		//CountryAbstractFactory.createStateFactory(India.class.getName())..getAllStates();
	}

}
