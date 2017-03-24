package com.pg.dp.abstfactory;


public interface CountryFactory{

	CountryFactory IMPOBJ = AbstractFactoryHelper.createFactoryInstance(CountryFactory.class);
	
	public Country createCountry(); /*{
		if(StringUtils.isNotBlank(classname) && classname.toUpperCase().contains("USA")){
			return FactoryHelper.getInstance(USAStateFactory.class.getName());
		}else if(StringUtils.isNotBlank(classname) && classname.toUpperCase().contains("INDIA")){
			return FactoryHelper.getInstance(IndiaStateFactory.class.getName());
		}else{
			return null;
		}
	}*/
}
